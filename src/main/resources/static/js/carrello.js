
    document.addEventListener('DOMContentLoaded', function() {
        var forms = document.getElementsByClassName('myForm');

        Array.from(forms).forEach(function(form) {
            form.addEventListener('submit', function(event) {
                event.preventDefault();

                var formData = new FormData(form);

                fetch(form.action, {
                    method: 'POST',
                    body: formData
                })
                .then(function(response) {
                    if (response.ok) {
                        console.log('Form submitted successfully');
                        refreshCartInfo();
                    } else {
                        throw new Error('Error submitting form');
                    }
                })
                .catch(function(error) {
                    console.log('Error submitting form: ' + error);
                });
            });
        });
    });

    function refreshCartInfo() {
      fetch('/cartInfo')
        .then(response => {
          if (!response.ok) {
            console.log('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          document.getElementsByClassName("item-count")[0].textContent = data.quantitaElementiCarrello.reduce((sub, current) => sub + current);
          document.getElementById("cart-subtotal").textContent = data.subTotale;
          document.getElementById("cart-total").textContent = data.subTotale + data.prezzoSpedizione;
      })
    }


