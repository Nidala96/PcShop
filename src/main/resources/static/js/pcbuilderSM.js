// TABELLA SCHEDA MADRE
document.getElementById("modalNewItemSM").addEventListener("click", function() {
    document.getElementById("modal-addSM").style.display = "block";
});

document.getElementById("closeAddSM").addEventListener("click", function() {
    document.getElementById("modal-addSM").style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target == document.getElementById("modal-addSM")) {
        document.getElementById("modal-addSM").style.display = "none";
    }
});