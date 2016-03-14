$(document).ready(function() {
    $('#tabAdherents').DataTable();
} );

$(document).ready(function() {
    $('#tabProprietaires').DataTable();
} );

$(document).ready(function () {
    $('.editForm').click(function(){
        var nom = $(this).data('nom');
        var prenom = $(this).data('prenom');
        var ville = $(this).data('ville');

        $('#nom').val(nom);
        $('#prenom').val(prenom);
        $('#ville').val(ville);
    });
});

$(document).ready(function () {
    $('#ajoutAdherentBtn').click(function(){
        $.ajax({
            url : 'adherent/editer',
            type : 'POST',
            dataType : 'json'
        });

    });
});
