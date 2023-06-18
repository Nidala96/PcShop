// TABELLA CPU
document.getElementById("modalNewItemRAM").addEventListener("click", function()
{
    console.log(document.getElementById("modalNewItemRAM"));
    document.getElementById("modal-addCPU").style.display = "block";
});

document.getElementById("closeAddRAM").addEventListener("click", function()
{
    document.getElementById("modal-addRAM").style.display = "none";
});

window.addEventListener("click", function(event)
{
    if (event.target == document.getElementById("modal-addRAM"))
    {
        document.getElementById("modal-addRAM").style.display = "none";
    }
});