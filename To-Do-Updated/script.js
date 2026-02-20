const taskInput = document.getElementById("taskInput");
const dueDateInput = document.getElementById("dueDate");
const taskList = document.getElementById("taskList");
const addBtn = document.getElementById("addBtn");

let tasks = JSON.parse(localStorage.getItem("tasks")) || [];
let currentFilter = "all";

/* ================= SAVE ================= */
function saveTasks() {
    localStorage.setItem("tasks", JSON.stringify(tasks));
}

/* ================= ADD TASK ================= */
addBtn.addEventListener("click", () => {
    const text = taskInput.value.trim();
    const dueDate = dueDateInput.value;

    if (!text) {
        alert("Task must not be empty");
        return;
    }

    tasks.push({
        id: Date.now(),
        text: text,
        dueDate: dueDate,
        completed: false
    });

    taskInput.value = "";
    dueDateInput.value = "";

    saveTasks();
    renderTasks();
});

/* ================= EDIT ================= */
function editTask(id) {
    const task = tasks.find(t => t.id === id);
    const newText = prompt("Edit Task:", task.text);

    if (!newText) return;

    task.text = newText.trim();
    saveTasks();
    renderTasks();
}

/* ================= DELETE ================= */
function deleteTask(id) {
    tasks = tasks.filter(task => task.id !== id);
    saveTasks();
    renderTasks();
}

/* ================= TOGGLE ================= */
function toggleCompleted(id) {
    const task = tasks.find(task => task.id === id);
    task.completed = !task.completed;
    saveTasks();
    renderTasks();
}

/* ================= FILTER ================= */
function setFilter(state) {
    currentFilter = state;
    renderTasks();
}

/* ================= RENDER ================= */
function renderTasks() {
    taskList.innerHTML = "";

    let filteredTasks = tasks;

    if (currentFilter === "completed") {
        filteredTasks = tasks.filter(t => t.completed);
    } else if (currentFilter === "pending") {
        filteredTasks = tasks.filter(t => !t.completed);
    }

    filteredTasks.forEach(task => {
        const li = document.createElement("li");
        li.draggable = true;
        li.dataset.id = task.id;

        if (task.completed) {
            li.classList.add("completed");
        }

        li.innerHTML = `
            <strong>${task.text}</strong>
            <small>Due: ${task.dueDate || "No date"}</small>
            <button onclick="toggleCompleted(${task.id})">✔</button>
            <button onclick="editTask(${task.id})">Edit</button>
            <button onclick="deleteTask(${task.id})">Delete</button>
        `;

        taskList.appendChild(li);
    });

    enableDragDrop();
}

/* ================= DRAG & DROP ================= */
function enableDragDrop() {
    const items = document.querySelectorAll("#taskList li");

    items.forEach(item => {
        item.addEventListener("dragstart", () => {
            item.classList.add("dragging");
        });

        item.addEventListener("dragend", () => {
            item.classList.remove("dragging");
            updateTaskOrder();
        });
    });

    taskList.addEventListener("dragover", e => {
        e.preventDefault();
        const dragging = document.querySelector(".dragging");
        const afterElement = getDragAfterElement(taskList, e.clientY);

        if (afterElement == null) {
            taskList.appendChild(dragging);
        } else {
            taskList.insertBefore(dragging, afterElement);
        }
    });
}

/* ================= DRAG POSITION ================= */
function getDragAfterElement(container, y) {
    const elements = [...container.querySelectorAll("li:not(.dragging)")];

    return elements.reduce((closest, child) => {
        const box = child.getBoundingClientRect();
        const offset = y - box.top - box.height / 2;

        if (offset < 0 && offset > closest.offset) {
            return { offset: offset, element: child };
        } else {
            return closest;
        }
    }, { offset: Number.NEGATIVE_INFINITY }).element;
}

/* ================= UPDATE ORDER ================= */
function updateTaskOrder() {
    const ids = [...taskList.children].map(li => Number(li.dataset.id));

    tasks.sort((a, b) => ids.indexOf(a.id) - ids.indexOf(b.id));

    saveTasks();
}

/* ================= INITIAL LOAD ================= */
renderTasks();
