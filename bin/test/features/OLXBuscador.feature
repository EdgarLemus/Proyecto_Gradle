Feature: Title of your feature

  Scenario Outline: <Escenario> <Producto>
    Given que me encuentro en la pagina de OLX con la url <Url>
    When busco el producto <Producto> en el buscador
    Then podre ver el producto <Producto> en pantalla

    Examples: 
      | Escenario                                        | Producto                                                              | Url                     |
      | Buscar el producto en el buscador de OLX exitoso | Moto Bmw Gs 1200 Adventure                                            | https://www.olx.com.co/ |
      | Buscar el producto en el buscador de OLX exitoso | Procesador Intel Core I3-3240 Quad core a 3.4 Ghz. Tercera generación | https://www.olx.com.co/ |
