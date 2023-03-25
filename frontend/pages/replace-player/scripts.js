import { getStudentByID, putStudent } from "../../commons/requests.js";

const replaceStudentForm = document
  .getElementById("replaceStudentForm")
  .querySelector("form");

let oldStudentData;

const loadStudentData = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const studentId = urlParams.get("id");

  oldStudentData = await getStudentByID(studentId);
  replaceStudentForm.studentName.value = oldStudentData.name;
  replaceStudentForm.studentLastname.value = oldStudentData.lastname;
};

const handleFormSubmit = async () => {
  replaceStudentForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const student = {
      name:
        oldStudentData.name !== replaceStudentForm.studentName.value
          ? replaceStudentForm.studentName.value
          : undefined,
      lastname:
        oldStudentData.lastname !== replaceStudentForm.studentLastname.value
          ? replaceStudentForm.studentLastname.value
          : undefined,
    };

    await putStudent(student, oldStudentData.id);
    window.location.replace("../student-list/student-list.html");
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../student-list/student-list.html");
  });
};

(async () => {
  await loadStudentData();
  handleCancelButton();
  await handleFormSubmit();
})();
