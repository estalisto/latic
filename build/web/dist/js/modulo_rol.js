/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function modulos()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("modulos?accion=listar",{},function(){ });
}




function ActivaModulo(str,str_lvl,str_grp){
    
    var id = str;
    var empresa = $("#empresa").val();
    var rol=$("#rol").val();
    var nivel = str_lvl;
    var grupo = str_grp;
    var accion="registrar";
    //alert(grupo);
     var parametros = {
                "id" : id,
                "empresa" : empresa,
                "rol" : rol,
                "nivel" : nivel,
                "grupo": grupo,
                "accion" : accion
                };
                $.ajax({
                        data:  parametros, 
                        url:   'modulos',
                        type:  'GET',
                        beforeSend: function () {                      
                        } ,
                       success:  function (response) {
                              if(response === "true"){
                                  alert("Modulo ya se encuentra registrado");
                                  //
                                }else{
                                    alert("Modulo registrado exitosamente");
                                   
                                  modulos_asignados(empresa,rol); 
                                    
                                }                        
                        }
                });  
}


function Desactivar(data)
{
    var id = data;
    var empresa = $("#empresa").val();
    var rol=$("#rol").val();
    var accion="desactivar";
    
    if(confirm("Desea desactivar el Modulo")){
     var parametros = {
                "id" : id,
                "empresa" : empresa,
                "rol" : rol,
                "accion" : accion
                };
                $.ajax({
                        data:  parametros, 
                        url:   'modulos',
                        type:  'GET',
                        beforeSend: function () {                      
                        } ,
                       success:  function (response) {
                              if(response === "true"){
                                  //alert("Modulo eliminado");
                                  //
                                }else{
                                    alert("Modulo eliminado exitosamente");
                                   
                                  modulos_asignados(empresa,rol); 
                                   
                                }                        
                        }
                });  

    //jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      //  jQuery("#page-wrapper").load("modulos?accion=desactivar&id=" + data,{},function(){ });
        }
        
}



function modulos_asignados(empresa,rol)
{   
    jQuery("#pagetable").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
    jQuery("#pagetable").load("modulos?accion=listar_modulos&empresa="+empresa+"&rol="+rol,{},function(){ });
}

$('#btncrearmodulo').click(function(e){
   e.preventDefault();
   var empresa = $("#empresa").val();
   var rol = $("#rol").val();

  
   if(empresa !== ""){
       if(rol !== ""){
           $('#list_modulo').css("display", "block");
        $('#asig_modulo').css("display", "block");
        document.getElementById("empresa").disabled = true;
         document.getElementById("rol").disabled = true;
         document.getElementById("btncrearmodulo").disabled = true;
         /// llama  la funcion y pasale los parametros 
         modulos_asignados(empresa,rol);  
       }else{ alert("Debe seleccionar un rol");}
    } else{ alert("Debe seleccionar una empresa");}
       
});

