function frm_parametros()
{
   // alert("Url  ="+document.location);
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("parametros?accion=agregar",{},function(){ });
}

function parametro()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("parametros?accion=listar",{},function(){ });
}

function deleteparametro(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("parametros?accion=eliminar&id=" + data,{},function(){ });
        }
        parametros();
}

function validaDatos(codigo,parametross,valor,accion){
         
            if(codigo.length > 1  ){
                if(parametross.length > 1 ){
                    if(valor.length > 1 ){
                        return true;
                    }else{ alert("Debe ingresar el valor del parametro");}
                }else{ alert("Debe ingresar parametros");}
            }else{ alert("Debe ingresar codigo parametro");}
               
   return false; 
}

function ConnsultaDatosID(str)        
{  
 
  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("parametros?accion=buscaID&id=" + str,{},function(){ });
  }
    
}

$('#btncrearparametro').click(function(e){
   e.preventDefault();
   var codigo = $("#codigo").val();
   var nombre = $("#nombre").val();
   var valor = $("#valor").val();
    
    var accion = $("#accion").val();
   
   //alert(t_identificacion);
   if(validaDatos(codigo,nombre,valor,accion)){
      
          var parametros = {
                "accion" : accion,
                "codigo" : codigo,
                "nombre" : nombre,
                "valor" : valor };
        $.ajax({
                data:  parametros,
                url:   'parametros',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                            frm_parametros();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
   }
});

$('#btnactparametro').click(function(e){
   e.preventDefault();
   
    var codigo = $("#codigo").val();
    var nombre = $("#nombre").val();
    var valor = $("#valor").val();
    var accion = $("#accion").val();
    var id= $("#id").val();
   
    
             var parametros = {
                "id":id,
                "accion" : accion,
                "codigo" : codigo,
                "nombre" : nombre,
                "valor" : valor  };
        $.ajax({
                data:  parametros,
                url:   'parametros',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           parametro();
                      }                        
                }
        });  
});
function ValidaSoloNumeros() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}
//Validadacion que los campos sean texto
function txNombres() {
    if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
        event.returnValue = false;
}
