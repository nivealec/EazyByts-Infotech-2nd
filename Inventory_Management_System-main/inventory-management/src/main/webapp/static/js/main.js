// main.js

$(document).ready(function() {
    // Function to fetch all products and populate the table
    function fetchProducts() {
        $.get("/api/products", function(products) {
            $('#productList').empty();
            $.each(products, function(index, product) {
                var row = '<tr>' +
                          '<td>' + product.productName + '</td>' +
                          '<td>' + product.description + '</td>' +
                          '<td>' + product.barcode + '</td>' +
                          '</tr>';
                $('#productList').append(row);
            });
        });
    }

    // Initial fetch of products when the page loads
    fetchProducts();

    // Add Product form submission
    $('#productForm').submit(function(event) {
        event.preventDefault();

        var formData = {
            productName: $('#productName').val(),
            description: $('#description').val(),
            barcode: $('#barcode').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/products/addProduct',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                console.log('Product added successfully');
                fetchProducts(); // Refresh the product list
                $('#productName, #description, #barcode').val(''); // Clear input fields
            },
            error: function(error) {
                console.error('Error adding product:', error);
                alert('Error adding product');
            }
        });
    });
});
