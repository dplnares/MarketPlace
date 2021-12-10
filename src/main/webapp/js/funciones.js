/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    $('tr #btnDelete').click(function (){
        var idProducto=$(this).parent().find("#idProducto").val();
        swal({
            title: "Estas seguro de Eliminar?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })  .then((willDelete) => {
            if (willDelete) {
                eliminar(idProducto);
                swal("Poof! Your imaginary file has been deleted!", {
                  icon: "success",
                }).then((willDelete) => {
                    if(willDelete){
                        parent.location.href="ControladoProducto?accion=Carrito";
                    }
                });
            } else {
              swal("Registro no eliminado!");
            }
        });
        
    });
    function eliminar(idProducto){
        var url="ControladoProducto?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idProducto="+idProducto,
            success: function (data, textStatus, jqXHR) {      
                alert("eliminado");
            }
        });
    }
    $("tr #Cantidad").click(function (){
        var idProducto=$(this).parent().find("#idProducto").val();
        var cantidad=$(this).parent().find("#Cantidad").val();
        var url="ControladoProducto?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idProducto="+idProducto+"&Cantidad="+cantidad,
            success: function (data, textStatus, jqXHR) {     
                location.href="ControladoProducto?accion=Carrito"
            }
        });
    })
});

