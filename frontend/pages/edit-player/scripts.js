import { getStudentByID, patchStudent } from "../../commons/requests.js";

const editStudentForm = document
  .getElementById("editStudentForm")
  .querySelector("form");

let oldStudentData;

const loadStudentData = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const studentId = urlParams.get("id");

  oldStudentData = await getStudentByID(studentId);
  editStudentForm.studentName.value = oldStudentData.name;
  editStudentForm.studentLastname.value = oldStudentData.lastname;
};

const handleFormSubmit = async () => {
  editStudentForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const student = {
      name:
        oldStudentData.name !== editStudentForm.studentName.value
          ? editStudentForm.studentName.value
          : undefined,
      lastname:
        oldStudentData.lastname !== editStudentForm.studentLastname.value
          ? editStudentForm.studentLastname.value
          : undefined,
    };

    await patchStudent(student, oldStudentData.id);
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
