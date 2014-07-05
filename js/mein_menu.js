/*
   -------------------------------------------------
   jQuery-Selektoren, Klassen, IDs anpassen!

   Falls 'nav' keine ID hat und es nur 1 'nav' gibt,
   dann z.B.: $("nav ul").
   -------------------------------------------------
*/
$(document).ready(function(){
  // Folgende Funktion wird ausgefuehrt,
  // - bei Seitenaufruf oder
  // - bei jedem Resize des Browser-Fensters:

  var adjust_my_nav = function() {

    // Falls '.menubutton' sichtbar
    //    s. '.menubutton' im Stylesheet mit 'display:block'
    //    bei @media only screen and (max-width: 480px)!

    if ( $(".menubutton").css('display') != 'none' ) {

      // verstecke zuerst die sichtbare Navigation...
      $("#mainnav ul").css("display", "none");

      // ...und bei Klick auf '.menubutton'
      // zeige/verstecke die Navigation mittels 'slideToggle()':

      $(".menubutton a").on("click", function(ev){
        ev.preventDefault();
        $("#mainnav ul").slideToggle(400);
      });
    }
    else {
      $("#mainnav ul").css("display", "block");
    }
  };
  // end of function 'adjust_my_nav'


  // bei Seitenaufruf:
  adjust_my_nav();

  // bei jedem Fenster-resize:
  $(window).resize(function() {
    // Reset toggle  (falls Resizing bei sichtbarer Nav gemacht wird)
    $(".menubutton a").off();

    adjust_my_nav();
  });

});