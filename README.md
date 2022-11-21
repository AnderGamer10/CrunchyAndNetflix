# CrunchyAndNetflix

1. > Activities y fragmentos principales
    - IntroActivity:
        - En este activity es donde se hace la carga de la API, la carga de los shared preferences y donde se activa el modo oscuro de la aplicacion.
    - MainActivity: 
        - Activity principal donde se mostrara el bottom navigation bar y sus fragmentos aderidos.
    - HomeFragment:
        - Este fragmento sera el primero en cargar ya que es como una pagina de "inicio" donde se mostrara una caratula de una serie (al azar) y varias listas como por ejemplo, Mas popular, anime...
    - SearchFragment:
        - En este fragmento apareceran todas las series que hay y tambien un searchview para buscar la serie deseada.
    - CatalogueFragment: 
        - Un catalogo donde se muestran todos los generos en el cuando clicas aparecen todas la series con ese genero (GenreActivity).
    - FavoriteFragment:
        - Un fragmento donde apareceran todas las series favoritas que tienes.
    > Activities Extras:
    - GenreActivity:
        - Aqui se mostraran todos y cada uno de las series del genero seleccionado en el catalogo.
    - SerieActivity:
        - Una vez se clique en una serie se mostrara los datos de esa serie.
    
2. > Funcionalidades
    - Al clicar en una serie cualquiera aparecera su informacion (SerieActivity).
    - En cada serie hay un icono de "favoritos/bookmark" que al darle se añadira a favoritos donde se mostraran en FavoriteFragment.
    - Un buscador funcional en el SearchFragment.
    - En HomeFragment la caratula es random por lo tanto siempre que se entre en el se actualizara y pondra otra diferente, tambien la lista de "terror" los que aparecen son random pero teniendo el genero "Horror".
    - En el catalogo se puede elegir el genero deseado y al darle apareceran todas las series con ese genero
