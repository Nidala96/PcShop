// TABELLA CPU
document.getElementById("modalNewItemCPU").addEventListener("click", function() {
    console.log(document.getElementById("modalNewItemCPU"));
    document.getElementById("modal-addCPU").style.display = "block";
});

document.getElementById("closeAddCPU").addEventListener("click", function() {
    document.getElementById("modal-addCPU").style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target == document.getElementById("modal-addCPU")) {
        document.getElementById("modal-addCPU").style.display = "none";
    }
});
