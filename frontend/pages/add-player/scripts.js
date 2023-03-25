import { saveStudent } from "../../commons/requests.js";

const handleFormSubmit = async () => {
  const form = document.getElementById("addStudentForm").querySelector("form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const student = {
      name: form.studentName.value,
      lastname: form.studentLastname.value,
    };
    await saveStudent(student);
    window.location.reload();
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../student-list/student-list.html");
  });
};

(async () => {
  handleCancelButton();
  await handleFormSubmit();
})();
