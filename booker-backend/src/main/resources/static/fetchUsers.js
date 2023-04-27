const rowsPerPage = 5;
let currentPage = 0;
let totalPages = 0;

async function searchUsers() {
    const searchTerm = document.getElementById('searchInput').value;
    currentPage = 0;
    await fetchUsers(currentPage, searchTerm);
}

async function fetchUsers(page, searchTerm = "") {
    try {
        const response = await fetch(
            `http://localhost:8080/api/users?page=${page}&size=${rowsPerPage}&search=${searchTerm}`
        );
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const data = await response.json();
        const users = data.content;
        console.log(users)
        totalPages = data.totalPages;
        console.log(`Total pages: ${totalPages}`)
        renderTable(users);
    } catch (error) {
        console.error('Error fetching users:', error);
    }
}

function renderTable(users) {
    const usersTableBody = document.getElementById('usersTableBody');
    usersTableBody.innerHTML = '';

    for (const user of users) {
        const tr = document.createElement('tr');
        const roles = user.roles.join(', ');
        tr.innerHTML = `
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${roles}</td>
    `;
        usersTableBody.appendChild(tr);
    }
    renderPagination();
}

function renderPagination() {
    const paginationList = document.getElementById('paginationList');
    paginationList.innerHTML = '';

    for (let i = 0; i < totalPages; i++) {
        const li = document.createElement('li');
        li.innerHTML = `
      <a class="pagination-link${i === currentPage ? ' is-current' : ''}" onclick="goToPage(${i})">${i + 1}</a>
    `;
        paginationList.appendChild(li);
    }

    document.getElementById('previousPage').disabled = currentPage === 0;
    document.getElementById('nextPage').disabled = currentPage === totalPages - 1;
}

function goToPage(page) {
    currentPage = page;
    searchUsers();
    fetchUsers(currentPage);
}

function nextPage() {
    if (currentPage < totalPages - 1) {
        currentPage++;
        searchUsers();
        fetchUsers(currentPage);
    }
}

function previousPage() {
    if (currentPage > 0) {
        currentPage--;
        searchUsers();
        fetchUsers(currentPage);
    }
}

fetchUsers(currentPage);
