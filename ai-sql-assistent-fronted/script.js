const generateBtn = document.getElementById("generate-btn");
const userQuery = document.getElementById("user-query");
const outputCode = document.getElementById("sql-output");
const copyBtn = document.getElementById("copy-btn");

// -------------------------
// Generate SQL
// -------------------------

async function generateSQL(promptText) {

    outputCode.textContent = "-- Generating SQL query, please wait...";
    generateBtn.disabled = true;
    generateBtn.textContent = "Generating...";

    try {
        const response = await fetch("http://localhost:8080/api/sql/generate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                prompt: promptText
            })
        });
        // Check if backend returned an error
        if (!response.ok) {
           throw new Error("Server error");
        }
        const data = await response.text();
        // Display generated SQL
        outputCode.textContent =data;
    } catch (error) {
        console.error(error);

        outputCode.textContent =
        "-- Error generating query. Please try again.";
    } finally {
        generateBtn.disabled = false;
        generateBtn.textContent = "Generate SQL";
    }
}

// -------------------------
// Generate Button
// -------------------------

generateBtn.addEventListener("click", () => {

    const query = userQuery.value.trim();

    if (!query) {
        outputCode.textContent =
        "-- Please describe the query you want to generate.";
        userQuery.focus();
        return;
    }

    generateSQL(query);

});

// -------------------------
// Enter Key
// -------------------------

userQuery.addEventListener("keydown", (event) => {

    if (event.key === "Enter") {
    generateBtn.click();
    }

});

// -------------------------
// Preset Query
// -------------------------

function setQuery(text) {

    userQuery.value = text;
    userQuery.focus();

    }

    // -------------------------
    // Copy SQL
    // -------------------------

    copyBtn.addEventListener("click", async () => {

        const sql = outputCode.textContent;
        if (
            !sql ||
            sql.startsWith("-- Your generated") ||
            sql.startsWith("-- Generating") ||
            sql.startsWith("-- Error")
        ) {
        return;
    }

    try {
        await navigator.clipboard.writeText(sql);
        copyBtn.innerHTML =
        '<i class="fa-solid fa-check"></i> Copied';
        setTimeout(() => {
        copyBtn.innerHTML =
            '<i class="fa-regular fa-copy"></i> Copy';

        }, 1500);
        } catch (error) {
        console.error("Copy failed:", error);
    }

});
