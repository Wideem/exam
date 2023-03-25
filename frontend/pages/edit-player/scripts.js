import { getPlayerByID, patchPlayer } from "../../commons/requests.js";

const editPlayerForm = document
  .getElementById("editPlayerForm")
  .querySelector("form");

let oldPlayerData;

const loadPlayerData = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const playerId = urlParams.get("id");

  oldPlayerData = await getPlayerByID(playerId);
  editPlayerForm.playerName.value = oldPlayerData.name;
  editPlayerForm.playerLastname.value = oldPlayerData.lastname;
};

const handleFormSubmit = async () => {
  editPlayerForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const player = {
      name:
        oldPlayerData.name !== editPlayerForm.playerName.value
          ? editPlayerForm.playerName.value
          : undefined,
      lastname:
        oldPlayerData.lastname !== editPlayerForm.playerLastname.value
          ? editPlayerForm.playerLastname.value
          : undefined,
    };

    await patchPlayer(player, oldPlayerData.id);
    window.location.replace("../player-list/player-list.html");
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../player-list/player-list.html");
  });
};

(async () => {
  await loadPlayerData();
  handleCancelButton();
  await handleFormSubmit();
})();
