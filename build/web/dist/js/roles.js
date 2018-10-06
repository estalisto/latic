function frm_roles()
{
   // alert("Url  ="+document.location);
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("agregar_rol",{},function(){ });
}
function roles()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("lista_roles",{},function(){ });
}


$('#btncrearrol').click(function(e){
e.preventDefault();
    var empresa=$('#empresa').val(); // document.rol..value;
    var rol=$('#rol').val().toUpperCase(); //document.rol.rol.value;
    //alert(empresa);
    if (empresa == "" || empresa == null){
        alert("Debe seleccionar una Empresa");
        return false;  
    }
    if($('#rol').val() == "" || $('#rol').val() == null){
        alert("Debe Ingresar el ROL");
        return false;  
    }
    var parametros = {
                "empresa" : empresa,
                "rol" : rol
        };
        $.ajax({
                data:  parametros,
                url:   'crear_rol',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           frm_roles();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
});



function enviarDatosRoles()
{
    var empresa=$('#empresa').val(); // document.rol..value;
    var rol=$('#rol').val().toUpperCase(); //document.rol.rol.value;
    
    if (empresa == "" || empresa == null){
        alert("Debe seleccionar una Empresa");
        return false;  
    }
    if($('#rol').val() == "" || $('#rol').val() == null){
        alert("Debe Ingresar el ROL");
        return false;  
    }
    
    var parametros = {
                "empresa" : empresa,
                "rol" : rol
        };
        $.ajax({
                data:  parametros,
                url:   'crear_rol',
                type:  'GET',
                beforeSend: function () {
                       // $("#info").html("<br/><br/><center><img alt='cargando' src='images/ajax-loader.gif' /><center>");
                } ,
               success:  function (response) {
                      
                        if(response){
                           alert("Registrado Exitosamente..");
                           frm_roles();//vuelvo a llamar a la pantalla
                         }                        
                }
        });
}

    function deleterol(data)        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("roles?accion=eliminar&id=" + data,{},function(){ });
        roles();
        }
        
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("roles?accion=buscaID&id=" + str,{},function(){ });
     
    }
    
}

$('#btnactrol').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var rol = $("#rol").val();

   
    var accion = $("#accion").val();
    var idrol= $("#idrol").val();
   

             var parametros = {
                "idrol":idrol,
                "accion" : accion,
                "empresa" : empresa,
                "rol" : rol
                  };
        $.ajax({
                data:  parametros,
                url:   'roles',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           
                           roles();//vuelvo a llamar a la pantalla
                      }                        
                }
        });  
});