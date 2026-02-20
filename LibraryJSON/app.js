const API = "http://localhost:5000/books";

const list = document.getElementById("bookList");
const addBtn = document.getElementById("addBtn");
const searchInput = document.getElementById("search");
const filterAuthorInput = document.getElementById("filterAuthor");

// Load Books
async function loadBooks() {
    const res = await fetch(API);
    const books = await res.json();
    render(books);
}

// Render Books
function render(books) {
    list.innerHTML = "";

    books.forEach(book => {
        const li = document.createElement("li");
        li.textContent = `${book.title} - ${book.author} (${book.category})`;
        li.className = book.available ? "available" : "issued";

        // Issue / Return Button
        const toggleBtn = document.createElement("button");
        toggleBtn.textContent = book.available ? "Issue" : "Return";
        toggleBtn.onclick = () => toggleBook(book);

        // Delete Button
        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.onclick = () => deleteBook(book.id);

        li.append(toggleBtn, deleteBtn);
        list.appendChild(li);
    });
}

// Add Book
async function addBook() {
    const title = document.getElementById("title").value.trim();
    const author = document.getElementById("author").value.trim();
    const category = document.getElementById("category").value.trim();

    if (!title || !author || !category) {
        alert("Please fill all fields");
        return;
    }

    await fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            title,
            author,
            category,
            available: true
        })
    });

    document.getElementById("title").value = "";
    document.getElementById("author").value = "";
    document.getElementById("category").value = "";

    loadBooks();
}

// Toggle Issue / Return
async function toggleBook(book) {
    await fetch(`${API}/${book.id}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            available: !book.available
        })
    });

    loadBooks();
}

// Delete Book
async function deleteBook(id) {
    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    loadBooks();
}

// Search Feature
searchInput.oninput = async () => {
    const res = await fetch(API);
    const books = await res.json();

    const term = searchInput.value.toLowerCase();

    const filtered = books.filter(book =>
        book.title.toLowerCase().includes(term)
    );

    render(filtered);
};

// Filter by Author
filterAuthorInput.oninput = async () => {
    const res = await fetch(API);
    const books = await res.json();

    const term = filterAuthorInput.value.toLowerCase();

    const filtered = books.filter(book =>
        book.author.toLowerCase().includes(term)
    );

    render(filtered);
};

addBtn.onclick = addBook;

// Initial Load
loadBooks();