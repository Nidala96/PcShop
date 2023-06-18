// TABELLA GPU
document.getElementById("modalNewItemGPU").addEventListener("click", function() {
    document.getElementById("modal-addGPU").style.display = "block";
});

document.getElementById("closeAddGPU").addEventListener("click", function() {
    document.getElementById("modal-addGPU").style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target == document.getElementById("modal-addGPU")) {
        document.getElementById("modal-addGPU").style.display = "none";
    }
});



