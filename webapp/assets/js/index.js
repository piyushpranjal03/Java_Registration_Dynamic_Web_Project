let form = document.querySelector("form");

form.addEventListener("focusin", e => {
  e.target.previousElementSibling.style.color = "var(--blue-dark)";
});

form.addEventListener("focusout", e => {
  e.target.previousElementSibling.style.color = "var(--text-muted)";
});

let data;

form.addEventListener("submit", e => {
  e.preventDefault();
  regRequest();
});

function sleep(ms) {
  return new Promise(res => setTimeout(res, ms));
}

// Parameters: (boolean, string)
// boolean: State of the form data process to enable or disable button
// string (optional): Response whatever received from server
async function formInProgress(state, response) {
  let btn = document.querySelector("button[type='submit']");
  let inputFields = document.querySelectorAll("input");
  for (let input of inputFields) {
    if (!state) {
      input.value = "";
    }
  }
  if (response) {
    response == 1 ? (btn.innerHTML = "Success") : "Failed";
  	await sleep(1500);
  }
  btn.disabled = state;
  btn.innerHTML = state ? "<div class='loader'></div>" : "Create an account";
  btn.style.cursor = state ? "not-allowed" : "pointer";
}

async function regRequest() {
  formInProgress(true);
  const formData = new FormData(form);
  const urlParameters = new URLSearchParams(formData);

  const response = await fetch("sign-up", { method: "POST", body: urlParameters });
  data = await response.text();
  await sleep(1000);
  formInProgress(false, Number.parseInt(data));
}
