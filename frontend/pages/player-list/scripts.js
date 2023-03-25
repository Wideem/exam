import { deletePlayerById, getPlayers } from "../../commons/requests.js";

const renderPlayerTableRows = async (players) => {
  const playerTable = document.getElementById("playerTable");
  const playerTableBody = playerTable.querySelector("tbody");
  players.forEach((p) => {
    const playerRow = document.createElement("tr");

    const nameCell = document.createElement("td");
    nameCell.innerText = p.name;
    playerRow.appendChild(nameCell);

    const lastnameCell = document.createElement("td");
    lastnameCell.innerText = p.lastname;
    playerRow.appendChild(lastnameCell);

    const ageCell = document.createElement("td");
    ageCell.innerText = p.age;
    playerRow.appendChild(ageCell);

    const emailCell = document.createElement("td");
    emailCell.innerText = p.email;
    playerRow.appendChild(emailCell);

    const genderCell = document.createElement("td");
    genderCell.innerText = p.gender;
    playerRow.appendChild(genderCell);


    const experienceCell = document.createElement("td");
    experienceCell.innerText = p.experience;
    playerRow.appendChild(experienceCell);

    const actionCell = document.createElement("td");


    const editButton = document.createElement("button");
    editButton.innerText = "EDIT";
    editButton.className = "btn btn-warning";
    editButton.style = "margin-right: 10px";
    editButton.addEventListener("click", async () => {
      window.location.replace(`../edit-player/edit-player.html?id=${p.id}`);
    });
    actionCell.appendChild(editButton);


    const deleteButton = document.createElement("button");
    deleteButton.innerText = "DELETE";
    deleteButton.className = "btn btn-danger";
    deleteButton.addEventListener("click", async () => {
      await deletePlayerById(p.id);
      window.location.reload();
    });
    actionCell.appendChild(deleteButton);

    playerRow.appendChild(actionCell);

    playerTableBody.appendChild(playerRow);
  });
};

const handleAddNewPlayerButton = () => {
  document.getElementById("addPlayer").addEventListener("click", () => {
    window.location.replace("../add-player/add-player.html");
  });
};

(async () => {
  handleAddNewPlayerButton();
  const player = await getPlayers();
  renderPlayerTableRows(player);
})();
