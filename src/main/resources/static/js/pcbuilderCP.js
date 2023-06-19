// TABELLA CP
document.getElementById("modalNewItemCP").addEventListener("click", function() {
    console.log(document.getElementById("modalNewItemCP"));
    document.getElementById("modal-addCP").style.display = "block";
});

document.getElementById("closeAddCP").addEventListener("click", function() {
    document.getElementById("modal-addCP").style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target == document.getElementById("modal-addCP")) {
        document.getElementById("modal-addCP").style.display = "none";
    }
});
