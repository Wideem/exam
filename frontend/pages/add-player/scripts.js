import { savePlayer } from "../../commons/requests.js";

const handleFormSubmit = async () => {
  const form = document.getElementById("addPlayerForm").querySelector("form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const player = {
      name: form.playerName.value,
      lastname: form.playerLastname.value,
      email: form.playerEmail.value,
      personCode: form.playerPersonCode.value,
      startDate: form.playerStartDate.value,
    };
    await savePlayer(player);
    window.location.reload();
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../player-list/player-list.html");
  });
};

(async () => {
  handleCancelButton();
  await handleFormSubmit();
})();
