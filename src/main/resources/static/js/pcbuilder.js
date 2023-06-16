var prezzototale = 0;
var priceCPU =0;
var priceGPU =0;
var priceSM =0;
var priceCPC =0;
var priceRAM =0;
var priceHD =0;

function addCPU(element) {
  var prezzoCPU = parseFloat(element.getAttribute('data-pprezzo'));
  document.getElementById("nCPU").textContent = element.getAttribute('data-pnome');
  document.getElementById("pCPU").textContent = prezzoCPU.toFixed(2);

  priceCPU = prezzoCPU;

    prezzototale =  0;
  prezzototale += prezzoCPU;


  calculateTotal();

}

function addGPU(element) {
  var prezzoGPU = parseFloat(element.getAttribute('data-gprezzo'));
  document.getElementById("nGPU").textContent = element.getAttribute('data-gnome');
  document.getElementById("pGPU").textContent = prezzoGPU.toFixed(2);
  prezzototale -= parseFloat(document.getElementById("pGPU").textContent);
  prezzototale += prezzoGPU;

  priceGPU = prezzoGPU;

   calculateTotal();
}

function addSCHEDAMADRE(element) {
  var prezzoSM = parseFloat(element.getAttribute('data-smprezzo'));
  document.getElementById("nSM").textContent = element.getAttribute('data-smnome');
  document.getElementById("pSM").textContent = prezzoSM.toFixed(2);
  prezzototale -= parseFloat(document.getElementById("pSM").textContent);
  prezzototale += prezzoSM;

  priceSM = prezzoSM;

  calculateTotal();


}

function addCASEPC(element) {
  var prezzoCASE = parseFloat(element.getAttribute('data-cpcprezzo'));
  document.getElementById("nCASE").textContent = element.getAttribute('data-cpcnome');
  document.getElementById("pCASE").textContent = prezzoCASE.toFixed(2);
  prezzototale -= parseFloat(document.getElementById("pCASE").textContent);
  prezzototale += prezzoCASE;



  priceCPC = prezzoCASE;

   calculateTotal();
}

function addRAM(element) {
  var prezzoRAM = parseFloat(element.getAttribute('data-ramprezzo'));
  document.getElementById("nRAM").textContent = element.getAttribute('data-ramnome');
  document.getElementById("pRAM").textContent = prezzoRAM.toFixed(2);
  prezzototale -= parseFloat(document.getElementById("pRAM").textContent);
  prezzototale += prezzoRAM;


  priceRAM = prezzoRAM;

   calculateTotal();
}

function addHARDDISK(element) {
  var prezzoHD = parseFloat(element.getAttribute('data-hdprezzo'));
  document.getElementById("nHD").textContent = element.getAttribute('data-hdnome');
  document.getElementById("pHD").textContent = prezzoHD.toFixed(2);
  prezzototale -= parseFloat(document.getElementById("pHD").textContent);
  prezzototale += prezzoHD;


  priceHD = prezzoHD;

   calculateTotal();
}

function calculateTotal() {
  document.getElementById("TOTAL").textContent =  (priceCPU + priceGPU + priceSM + priceCPC + priceRAM + priceHD);
  console.log(priceCPU + priceGPU + priceSM + priceCPC + priceRAM + priceHD)
  console.log(document.getElementById("TOTAL").textContent);
}



 /*document.getElementById("modalNewItemGPU").onclick = function()
{
	document.getElementById("modal-addGPU").style.display = "block";
	console.log(hello)

} */

document.getElementById("closeAddGPU").onclick = function()
{
	document.getElementById("modal-addGPU").style.display = "none";
}

document.getElementById("closeModGPU").onclick = function()
{
	document.getElementById("modal-modGPU").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modGPU"))
	{
		document.getElementById("modal-modGPU").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addGPU"))
	{
		document.getElementById("modal-addGPU").style.display = "none";
	}
}












