/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function frm_zona()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("sectores?accion=agregar",{},function(){ });
}
function sectores()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("sectores?accion=listar",{},function(){ });
}

function validaDatos(empresa,nombre,pais,provincia,ciudad,descripcion,accion){
         
             if(nombre.length > 1  ){
                 if(pais.length > 1 ){
                      
                            if(ciudad.length > 0 ){
                                     if(descripcion.length > 1 && descripcion.length < 100 ){
                                             return true;
                                 }else{ alert("Debe ingresar una descripcion");}
                           }else{ alert("Debe elegir una ciudad");}
                           
                    }else{ alert("Debe elegir un pais");}
             }else{ alert("Debe ingresar un Nombre");}
                 
   return false; 
}

function deletezona(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("sectores?accion=eliminar&id=" + data,{},function(){ });
        }
        sectores();
}

//function updatezona(id,empresa,pais,provincia,ciudad,nombre,descripcion)
//        
//{      
//    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
//        jQuery("#page-wrapper").load("sectores?accion=editar&id=" + id+"&empresa=" + empresa+"&pais=" + pais+"&provincia=" + provincia+"&ciudad=" + ciudad+"&nombre=" + nombre+"&descripcion=" + descripcion,{},function(){ });
//   
//}


function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("sectores?accion=buscaID&id=" + str,{},function(){ });
  }
    
}


function elimino(url){
    if(confirm("Realmente desea eliminar este registro")){
        window.location=url;
    }
}


$('#btncrearzona').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var nombre  = $("#nombre").val();
   var pais = $("#pais").val();
   var provincia = $("#provincia").val();
   var ciudad = $("#ciudad").val();
   var descripcion  = $("#descripcion").val();
  var accion = $("#accion").val();
   
   if(validaDatos(empresa,nombre,pais,provincia,ciudad,descripcion,accion)){
      
          var parametros = {
              "accion" : accion,
                "empresa" : empresa,
                "nombre" : nombre,
                "pais" : pais,
                "provincia" : provincia,
                "ciudad" : ciudad,
                "descripcion" : descripcion
                
                 };
        $.ajax({
                data:  parametros,
                url:   'sectores',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           frm_zona();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
       
       
        
   }
    
});



$('#btnactzona').click(function(e){
   e.preventDefault();
   

       
       var idzona = $("#idzona").val();
   var empresa = $("#empresa").val();
   var nombre  = $("#nombre").val();
   var pais = $("#pais").val();
   var provincia = $("#provincia").val();
   var ciudad = $("#ciudad").val();
   var descripcion  = $("#descripcion").val();
  var accion = $("#accion").val();
   
             var parametros = {
              "accion" : accion,
                "idzona" : idzona,
                "empresa" : empresa,
                "nombre" : nombre,
                "pais" : pais,
                "provincia" : provincia,
                "ciudad" : ciudad,
                "descripcion" : descripcion
                
                 };
        $.ajax({
                data:  parametros,
                url:   'sectores',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           sectores();//vuelvo a llamar a la pantalla
                      }                        
                }
        });  
   
   
 
    
       
});
