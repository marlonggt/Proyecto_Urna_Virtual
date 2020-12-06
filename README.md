# Urna Virtual 2020

El Proyecto urna virtual, se trata de llevar las elecciones nacionales a una plataforma virtual (localmente, utilizando archivos de preferencia, base de datos es opcional). 
En cuanto a los requisitos el programa realizará algunas validaciones. Entre las cuales tenemos.

    1. Las validaciones requeridas para cada uno de los candidatos, al momento de crear un candidato, se tendrá que llenar un formulario con los requisitos necesarios para poder optar al cargo publico en el que quiere inscribirse.
    2. Tendrá un área de configuración donde le permitirá al usuario administrador, configurar los candidatos por departamentos y municipios, configurar cantidad de candidatos a diputados por departamento, crear partidos políticos, crear candidatos sin partidos o no.

En cuanto a funcionalidad, el programa iniciará solicitándole al usuario su numero de identidad, con este numero se validará si el usuario ha votado ya, de ser así, le dirá que no puede realizar una nueva elección. Caso contrario, le solicitará departamento y municipio, con esa información se mostrarán las papeletas, inicialmente se mostrará la de alcaldía, seguida por la de diputaciones y concluirá con la presidencial. Una vez culminado el proceso de elección se terminará el proceso para ese usuario y se mostrará el mensaje de bienvenida, para el siguiente usuario.
Toda la configuración e información obtenida por la aplicación se podrá almacenar en archivos o en base de datos.

Una vez concluida la jornada el usuario administrador, podrá cerrar las elecciones, y solicitarle al sistema realizar el conteo final para saber quien es el ganador en cada una de las instancias.
En el proyecto se deberá implementar clases, herencia y polimorfismo. 
