<%-- 
    Document   : registro
    Created on : 23 nov 2024, 13:44:02
    Author     : gamaliel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesRegistro.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>   

        <header class="sticky-header">
            <a href="index.jsp" class="back-button">
                <span class="material-icons">arrow_back_ios</span>
            </a>
            <h1>ANIMAL SOCIAL</h1>
        </header>


        <section class="section" id="register-section">
            <h4 title="texto-Registro">Registrarse</h4>
            <form id="registroForm">
                <div class="form-group">
                    <input type="text" placeholder="Nombre Completo" id="nombre" required>
                    <i class="uil uil-user"></i>
                    <span class="error-message" id="nombreError"></span>
                </div>
                <div class="form-group">
                    <input type="email" placeholder="Correo Electrónico" id="email" required>
                    <i class="uil uil-at"></i>
                    <span class="error-message" id="emailError"></span>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Contraseña (mín. 8 caracteres, mayúscula, minúscula)" id="password" required>
                    <i class="uil uil-lock-alt"></i>
                    <span class="error-message" id="passwordError"></span>
                </div>
                <div class="form-group">
                    <select id="pais" required>
                        <option value="">Selecciona tu país</option>
                    </select>
                    <i class="uil uil-globe"></i>
                    <span class="error-message" id="paisError"></span>
                </div>
                <div class="form-group">
                    <select id="estado" required>
                        <option value="">Selecciona tu estado</option>
                    </select>
                    <i class="uil uil-map-pin"></i>
                    <span class="error-message" id="estadoError"></span>
                </div>
                <div class="form-group">
                    <select id="ciudad" required>
                        <option value="">Selecciona tu ciudad</option>
                    </select>
                    <i class="uil uil-city"></i>
                    <span class="error-message" id="ciudadError"></span>
                </div>
                <div class="form-group">
                    <input type="tel" placeholder="Teléfono" id="telefono" required>
                    <i class="uil uil-phone"></i>
                    <span class="error-message" id="telefonoError"></span>
                </div>
                <div class="form-group">
                    <input type="date" placeholder="Fecha de Nacimiento" id="fechaNacimiento" required>
                    <i class="uil uil-calendar-alt"></i>
                    <span class="error-message" id="fechaNacimientoError"></span>
                </div>
                <div class="radio-group">
                    <label><input type="radio" name="genero" value="hombre" required> Hombre</label>
                    <label><input type="radio" name="genero" value="mujer" required> Mujer</label>
                    <label><input type="radio" name="genero" value="no-binario" required> No binario</label>
                    <span class="error-message" id="generoError"></span>
                </div>
                <div class="form-group">
                    <select id="bando" required>
                        <option value="">Selecciona tu bando</option>
                        <option value="terrestre">Animales Terrestres</option>
                        <option value="marino">Animales Marinos</option>
                        <option value="aereo">Animales Aéreos</option>
                    </select>
                    <i class="uil uil-users-alt"></i>
                    <span class="error-message" id="bandoError"></span>
                </div>

                <button type="submit" class="btn btn-success" id="btnRegistro">Registrarse</button>
            </form>
        </section>
        <script>
    document.addEventListener('DOMContentLoaded', function() {
        const datosPaises = {
       "MX": {
            nombre: "México",
            estados: {
                "AGS": { nombre: "Aguascalientes", ciudades: ["Aguascalientes", "Jesús María", "Rincón de Romos"]},
                            "BC": {nombre: "Baja California", ciudades: ["Tijuana", "Mexicali", "Ensenada", "Rosarito"]},
                            "BCS": {nombre: "Baja California Sur", ciudades: ["La Paz", "Los Cabos", "Comondú"]},
                            "CAM": {nombre: "Campeche", ciudades: ["Campeche", "Ciudad del Carmen", "Champotón"]},
                            "CHIS": {nombre: "Chiapas", ciudades: ["Tuxtla Gutiérrez", "San Cristóbal de las Casas", "Tapachula"]},
                            "CHIH": {nombre: "Chihuahua", ciudades: ["Chihuahua", "Ciudad Juárez", "Delicias"]},
                            "COAH": {nombre: "Coahuila", ciudades: ["Saltillo", "Torreón", "Monclova"]},
                            "COL": {nombre: "Colima", ciudades: ["Colima", "Manzanillo", "Tecomán"]},
                            "CDMX": {nombre: "Ciudad de México", ciudades: ["México City", "Iztapalapa", "Gustavo A. Madero", "Álvaro Obregón"]},
                            "DGO": {nombre: "Durango", ciudades: ["Durango", "Gómez Palacio", "Lerdo"]},
                            "GTO": {nombre: "Guanajuato", ciudades: ["León", "Irapuato", "Celaya", "Guanajuato"]},
                            "GRO": {nombre: "Guerrero", ciudades: ["Acapulco", "Chilpancingo", "Iguala"]},
                            "HGO": {nombre: "Hidalgo", ciudades: ["Pachuca", "Tulancingo", "Tizayuca"]},
                            "JAL": {nombre: "Jalisco", ciudades: ["Guadalajara", "Puerto Vallarta", "Tlaquepaque", "Zapopan"]},
                            "MEX": {nombre: "Estado de México", ciudades: ["Toluca", "Naucalpan", "Tlalnepantla", "Ecatepec"]},
                            "MICH": {nombre: "Michoacán", ciudades: ["Morelia", "Uruapan", "Zamora"]},
                            "MOR": {nombre: "Morelos", ciudades: ["Cuernavaca", "Jiutepec", "Cuautla"]},
                            "NAY": {nombre: "Nayarit", ciudades: ["Tepic", "Bahía de Banderas", "Compostela"]},
                            "NL": {nombre: "Nuevo León", ciudades: ["Monterrey", "San Pedro", "San Nicolás", "Guadalupe"]},
                            "OAX": {nombre: "Oaxaca", ciudades: ["Oaxaca de Juárez", "Salina Cruz", "Juchitán de Zaragoza"]},
                            "PUE": {nombre: "Puebla", ciudades: ["Puebla", "Tehuacán", "San Andrés Cholula"]},
                            "QRO": {nombre: "Querétaro", ciudades: ["Querétaro", "San Juan del Río", "Corregidora"]},
                            "QROO": {nombre: "Quintana Roo", ciudades: ["Cancún", "Chetumal", "Playa del Carmen"]},
                            "SLP": {nombre: "San Luis Potosí", ciudades: ["San Luis Potosí", "Soledad de Graciano Sánchez", "Matehuala"]},
                            "SIN": {nombre: "Sinaloa", ciudades: ["Culiacán", "Mazatlán", "Los Mochis"]},
                            "SON": {nombre: "Sonora", ciudades: ["Hermosillo", "Ciudad Obregón", "Nogales"]},
                            "TAB": {nombre: "Tabasco", ciudades: ["Villahermosa", "Cárdenas", "Comalcalco"]},
                            "TAM": {nombre: "Tamaulipas", ciudades: ["Ciudad Victoria", "Tampico", "Nuevo Laredo"]},
                            "TLAX": {nombre: "Tlaxcala", ciudades: ["Tlaxcala", "Apizaco", "Huamantla"]},
                            "VER": {nombre: "Veracruz", ciudades: ["Veracruz", "Xalapa", "Coatzacoalcos"]},
                            "YUC": {nombre: "Yucatán", ciudades: ["Mérida", "Valladolid", "Progreso"]},
                            "ZAC": {nombre: "Zacatecas", ciudades: ["Zacatecas", "Fresnillo", "Guadalupe"]}
                        }
                    },
                    "ES": {
                        nombre: "España",
                        estados: {
                            "AND": {nombre: "Andalucía", ciudades: ["Sevilla", "Málaga", "Granada", "Córdoba", "Almería", "Jaén", "Huelva", "Cádiz"]},
                            "ARA": {nombre: "Aragón", ciudades: ["Zaragoza", "Huesca", "Teruel"]},
                            "AST": {nombre: "Asturias", ciudades: ["Oviedo", "Gijón", "Avilés"]},
                            "CAN": {nombre: "Cantabria", ciudades: ["Santander", "Torrelavega", "Castro Urdiales"]},
                            "CLM": {nombre: "Castilla-La Mancha", ciudades: ["Toledo", "Albacete", "Guadalajara", "Cuenca", "Ciudad Real"]},
                            "CYL": {nombre: "Castilla y León", ciudades: ["Valladolid", "Burgos", "Salamanca", "León", "Segovia", "Ávila", "Soria", "Palencia", "Zamora"]},
                            "CAT": {nombre: "Cataluña", ciudades: ["Barcelona", "Girona", "Tarragona", "Lleida"]},
                            "VAL": {nombre: "Comunidad Valenciana", ciudades: ["Valencia", "Alicante", "Castellón", "Elche"]},
                            "EXT": {nombre: "Extremadura", ciudades: ["Mérida", "Badajoz", "Cáceres"]},
                            "GAL": {nombre: "Galicia", ciudades: ["Santiago de Compostela", "A Coruña", "Vigo", "Lugo", "Ourense"]},
                            "MAD": {nombre: "Madrid", ciudades: ["Madrid", "Alcalá de Henares", "Móstoles", "Getafe", "Fuenlabrada", "Leganés"]},
                            "MUR": {nombre: "Región de Murcia", ciudades: ["Murcia", "Cartagena", "Lorca"]},
                            "NAV": {nombre: "Navarra", ciudades: ["Pamplona", "Tudela", "Estella"]},
                            "PVA": {nombre: "País Vasco", ciudades: ["Bilbao", "Vitoria-Gasteiz", "San Sebastián"]},
                            "RIO": {nombre: "La Rioja", ciudades: ["Logroño", "Calahorra", "Haro"]},
                            "CANAR": {nombre: "Canarias", ciudades: ["Santa Cruz de Tenerife", "Las Palmas de Gran Canaria", "La Laguna", "Telde"]},
                            "BAL": {nombre: "Islas Baleares", ciudades: ["Palma", "Ibiza", "Manacor", "Mahón"]},
                            "CEU": {nombre: "Ceuta", ciudades: ["Ceuta"]},
                            "MEL": {nombre: "Melilla", ciudades: ["Melilla"]}
                        }
                    },
                    "AR": {
                        nombre: "Argentina",
                        estados: {
                            "BUE": {nombre: "Buenos Aires", ciudades: ["La Plata", "Mar del Plata", "Quilmes", "Lanús", "Tigre", "Bahía Blanca", "Avellaneda"]},
                            "CABA": {nombre: "Ciudad Autónoma de Buenos Aires", ciudades: ["Buenos Aires"]},
                            "CAT": {nombre: "Catamarca", ciudades: ["San Fernando del Valle de Catamarca", "Belén", "Tinogasta"]},
                            "CHACO": {nombre: "Chaco", ciudades: ["Resistencia", "Presidencia Roque Sáenz Peña", "Villa Ángela"]},
                            "CHUB": {nombre: "Chubut", ciudades: ["Rawson", "Comodoro Rivadavia", "Puerto Madryn", "Trelew"]},
                            "COR": {nombre: "Córdoba", ciudades: ["Córdoba", "Villa María", "Río Cuarto", "Carlos Paz"]},
                            "CORR": {nombre: "Corrientes", ciudades: ["Corrientes", "Goya", "Paso de los Libres"]},
                            "ER": {nombre: "Entre Ríos", ciudades: ["Paraná", "Concordia", "Gualeguaychú", "Gualeguay"]},
                            "FOR": {nombre: "Formosa", ciudades: ["Formosa", "Clorinda", "Pirané"]},
                            "JUJ": {nombre: "Jujuy", ciudades: ["San Salvador de Jujuy", "Palpalá", "San Pedro"]},
                            "LP": {nombre: "La Pampa", ciudades: ["Santa Rosa", "General Pico", "Toay"]},
                            "LR": {nombre: "La Rioja", ciudades: ["La Rioja", "Chilecito", "Aimogasta"]},
                            "MEN": {nombre: "Mendoza", ciudades: ["Mendoza", "Godoy Cruz", "San Rafael", "Luján de Cuyo"]},
                            "MIS": {nombre: "Misiones", ciudades: ["Posadas", "Oberá", "Eldorado"]},
                            "NQN": {nombre: "Neuquén", ciudades: ["Neuquén", "San Martín de los Andes", "Cutral Có"]},
                            "RNE": {nombre: "Río Negro", ciudades: ["Viedma", "San Carlos de Bariloche", "General Roca"]},
                            "SAL": {nombre: "Salta", ciudades: ["Salta", "San Ramón de la Nueva Orán", "Tartagal"]},
                            "SJ": {nombre: "San Juan", ciudades: ["San Juan", "Rawson", "Caucete"]},
                            "SL": {nombre: "San Luis", ciudades: ["San Luis", "Villa Mercedes", "Merlo"]},
                            "SFE": {nombre: "Santa Fe", ciudades: ["Santa Fe", "Rosario", "Venado Tuerto", "Rafaela"]},
                            "SDE": {nombre: "Santiago del Estero", ciudades: ["Santiago del Estero", "La Banda", "Termas de Río Hondo"]},
                            "TDF": {nombre: "Tierra del Fuego", ciudades: ["Ushuaia", "Río Grande", "Tolhuin"]},
                            "TUC": {nombre: "Tucumán", ciudades: ["San Miguel de Tucumán", "Tafí Viejo", "Concepción"]}
                        }
                    },
                    "BR": {
                        nombre: "Brasil",
                        estados: {
                            "AC": {nombre: "Acre", ciudades: ["Rio Branco", "Cruzeiro do Sul", "Sena Madureira"]},
                            "AL": {nombre: "Alagoas", ciudades: ["Maceió", "Arapiraca", "Palmeira dos Índios"]},
                            "AP": {nombre: "Amapá", ciudades: ["Macapá", "Santana", "Oiapoque"]},
                            "AM": {nombre: "Amazonas", ciudades: ["Manaus", "Parintins", "Itacoatiara"]},
                            "BA": {nombre: "Bahía", ciudades: ["Salvador", "Feira de Santana", "Vitória da Conquista", "Camaçari"]},
                            "CE": {nombre: "Ceará", ciudades: ["Fortaleza", "Caucaia", "Juazeiro do Norte", "Sobral"]},
                            "DF": {nombre: "Distrito Federal", ciudades: ["Brasília", "Taguatinga", "Ceilândia", "Gama"]},
                            "ES": {nombre: "Espírito Santo", ciudades: ["Vitória", "Vila Velha", "Serra", "Cariacica"]},
                            "GO": {nombre: "Goiás", ciudades: ["Goiânia", "Aparecida de Goiânia", "Anápolis"]},
                            "MA": {nombre: "Maranhão", ciudades: ["São Luís", "Imperatriz", "Caxias"]},
                            "MT": {nombre: "Mato Grosso", ciudades: ["Cuiabá", "Várzea Grande", "Rondonópolis"]},
                            "MS": {nombre: "Mato Grosso do Sul", ciudades: ["Campo Grande", "Dourados", "Três Lagoas"]},
                            "MG": {nombre: "Minas Gerais", ciudades: ["Belo Horizonte", "Uberlândia", "Juiz de Fora", "Betim"]},
                            "PA": {nombre: "Pará", ciudades: ["Belém", "Santarém", "Ananindeua", "Marabá"]},
                            "PB": {nombre: "Paraíba", ciudades: ["João Pessoa", "Campina Grande", "Santa Rita"]},
                            "PR": {nombre: "Paraná", ciudades: ["Curitiba", "Londrina", "Maringá", "Ponta Grossa"]},
                            "PE": {nombre: "Pernambuco", ciudades: ["Recife", "Olinda", "Jaboatão dos Guararapes", "Caruaru"]},
                            "PI": {nombre: "Piauí", ciudades: ["Teresina", "Parnaíba", "Picos"]},
                            "RJ": {nombre: "Río de Janeiro", ciudades: ["Río de Janeiro", "Niterói", "Duque de Caxias", "Nova Iguaçu"]},
                            "RN": {nombre: "Río Grande del Norte", ciudades: ["Natal", "Mossoró", "Parnamirim"]},
                            "RS": {nombre: "Río Grande del Sur", ciudades: ["Porto Alegre", "Caxias do Sul", "Pelotas", "Canoas"]},
                            "RO": {nombre: "Rondônia", ciudades: ["Porto Velho", "Ji-Paraná", "Ariquemes"]},
                            "RR": {nombre: "Roraima", ciudades: ["Boa Vista", "Rorainópolis", "Caracaraí"]},
                            "SC": {nombre: "Santa Catarina", ciudades: ["Florianópolis", "Joinville", "Blumenau", "Itajaí"]},
                            "SP": {nombre: "São Paulo", ciudades: ["São Paulo", "Campinas", "Santos", "Guarulhos"]},
                            "SE": {nombre: "Sergipe", ciudades: ["Aracaju", "Nossa Senhora do Socorro", "Lagarto"]},
                            "TO": {nombre: "Tocantins", ciudades: ["Palmas", "Araguaína", "Gurupi"]}
                        }
                    },
                    "CL": {
                        nombre: "Chile",
                        estados: {
                            "XV": {nombre: "Arica y Parinacota", ciudades: ["Arica", "Putre"]},
                            "I": {nombre: "Tarapacá", ciudades: ["Iquique", "Alto Hospicio", "Pozo Almonte"]},
                            "II": {nombre: "Antofagasta", ciudades: ["Antofagasta", "Calama", "Tocopilla", "Mejillones"]},
                            "III": {nombre: "Atacama", ciudades: ["Copiapó", "Vallenar", "Chañaral"]},
                            "IV": {nombre: "Coquimbo", ciudades: ["La Serena", "Coquimbo", "Ovalle"]},
                            "V": {nombre: "Valparaíso", ciudades: ["Valparaíso", "Viña del Mar", "Quilpué", "San Antonio"]},
                            "RM": {nombre: "Región Metropolitana", ciudades: ["Santiago", "Puente Alto", "Maipú", "Las Condes", "La Florida"]},
                            "VI": {nombre: "O'Higgins", ciudades: ["Rancagua", "San Fernando", "Rengo"]},
                            "VII": {nombre: "Maule", ciudades: ["Talca", "Curicó", "Linares", "Cauquenes"]},
                            "VIII": {nombre: "Biobío", ciudades: ["Concepción", "Talcahuano", "Chiguayante", "Los Ángeles"]},
                            "IX": {nombre: "La Araucanía", ciudades: ["Temuco", "Villarrica", "Angol"]},
                            "XIV": {nombre: "Los Ríos", ciudades: ["Valdivia", "La Unión", "Panguipulli"]},
                            "X": {nombre: "Los Lagos", ciudades: ["Puerto Montt", "Osorno", "Castro"]},
                            "XI": {nombre: "Aysén", ciudades: ["Coyhaique", "Puerto Aysén", "Chile Chico"]},
                            "XII": {nombre: "Magallanes", ciudades: ["Punta Arenas", "Puerto Natales", "Porvenir"]}
                        }
                    },
                    "CO": {
                        nombre: "Colombia",
                        estados: {
                            "AMA": {nombre: "Amazonas", ciudades: ["Leticia", "Puerto Nariño"]},
                            "ANT": {nombre: "Antioquia", ciudades: ["Medellín", "Bello", "Itagüí", "Envigado", "Rionegro"]},
                            "ARA": {nombre: "Arauca", ciudades: ["Arauca", "Tame", "Saravena"]},
                            "ATL": {nombre: "Atlántico", ciudades: ["Barranquilla", "Soledad", "Malambo", "Puerto Colombia"]},
                            "BOL": {nombre: "Bolívar", ciudades: ["Cartagena", "Magangué", "Turbaco"]},
                            "BOY": {nombre: "Boyacá", ciudades: ["Tunja", "Duitama", "Sogamoso"]},
                            "CAL": {nombre: "Caldas", ciudades: ["Manizales", "Villamaría", "La Dorada"]},
                            "CAQ": {nombre: "Caquetá", ciudades: ["Florencia", "San Vicente del Caguán", "Cartagena del Chairá"]},
                            "CAS": {nombre: "Casanare", ciudades: ["Yopal", "Aguazul", "Villanueva"]},
                            "CAU": {nombre: "Cauca", ciudades: ["Popayán", "Santander de Quilichao", "Puerto Tejada"]},
                            "CES": {nombre: "Cesar", ciudades: ["Valledupar", "Aguachica", "Codazzi"]},
                            "CHO": {nombre: "Chocó", ciudades: ["Quibdó", "Istmina", "Condoto"]},
                            "COR": {nombre: "Córdoba", ciudades: ["Montería", "Lorica", "Cereté"]},
                            "CUN": {nombre: "Cundinamarca", ciudades: ["Bogotá", "Soacha", "Chía", "Cajicá", "Zipaquirá"]},
                            "GUA": {nombre: "Guainía", ciudades: ["Inírida"]},
                            "GUV": {nombre: "Guaviare", ciudades: ["San José del Guaviare", "Calamar"]},
                            "HUI": {nombre: "Huila", ciudades: ["Neiva", "Pitalito", "Garzón"]},
                            "LAG": {nombre: "La Guajira", ciudades: ["Riohacha", "Maicao", "Uribia"]},
                            "MAG": {nombre: "Magdalena", ciudades: ["Santa Marta", "Ciénaga", "Fundación"]},
                            "MET": {nombre: "Meta", ciudades: ["Villavicencio", "Acacías", "Granada"]},
                            "NAR": {nombre: "Nariño", ciudades: ["Pasto", "Tumaco", "Ipiales"]},
                            "NSA": {nombre: "Norte de Santander", ciudades: ["Cúcuta", "Ocaña", "Pamplona"]},
                            "PUT": {nombre: "Putumayo", ciudades: ["Mocoa", "Puerto Asís", "Orito"]},
                            "QUI": {nombre: "Quindío", ciudades: ["Armenia", "Montenegro", "La Tebaida"]},
                            "RIS": {nombre: "Risaralda", ciudades: ["Pereira", "Dosquebradas", "Santa Rosa de Cabal"]},
                            "SAN": {nombre: "San Andrés y Providencia", ciudades: ["San Andrés", "Providencia"]},
                            "SAN": {nombre: "Santander", ciudades: ["Bucaramanga", "Floridablanca", "Girón", "Barrancabermeja"]},
                            "SUC": {nombre: "Sucre", ciudades: ["Sincelejo", "Corozal", "Sampués"]},
                            "TOL": {nombre: "Tolima", ciudades: ["Ibagué", "Espinal", "Melgar"]},
                            "VAL": {nombre: "Valle del Cauca", ciudades: ["Cali", "Palmira", "Tuluá", "Buga", "Buenaventura"]},
                            "VAU": {nombre: "Vaupés", ciudades: ["Mitú"]},
                            "VID": {nombre: "Vichada", ciudades: ["Puerto Carreño"]}
                        }
                    }, "PE": {
                        nombre: "Perú",
                        estados: {
                            "AMA": {nombre: "Amazonas", ciudades: ["Chachapoyas", "Bagua", "Utcubamba"]},
                            "ANC": {nombre: "Áncash", ciudades: ["Huaraz", "Chimbote", "Casma", "Yungay"]},
                            "APU": {nombre: "Apurímac", ciudades: ["Abancay", "Andahuaylas", "Chalhuanca"]},
                            "ARE": {nombre: "Arequipa", ciudades: ["Arequipa", "Camaná", "Caylloma", "Islay"]},
                            "AYA": {nombre: "Ayacucho", ciudades: ["Ayacucho", "Huanta", "Vilcashuamán"]},
                            "CAJ": {nombre: "Cajamarca", ciudades: ["Cajamarca", "Jaén", "Cutervo", "Celendín"]},
                            "CUS": {nombre: "Cusco", ciudades: ["Cusco", "Urubamba", "Sicuani", "Quillabamba"]},
                            "HUV": {nombre: "Huancavelica", ciudades: ["Huancavelica", "Lircay", "Angaraes"]},
                            "HUA": {nombre: "Huánuco", ciudades: ["Huánuco", "Tingo María", "Ambo"]},
                            "ICA": {nombre: "Ica", ciudades: ["Ica", "Chincha Alta", "Pisco", "Nazca"]},
                            "JUN": {nombre: "Junín", ciudades: ["Huancayo", "Tarma", "Jauja", "La Oroya"]},
                            "LAL": {nombre: "La Libertad", ciudades: ["Trujillo", "Chepén", "Pacasmayo", "Virú"]},
                            "LAM": {nombre: "Lambayeque", ciudades: ["Chiclayo", "Lambayeque", "Ferreñafe"]},
                            "LIM": {nombre: "Lima", ciudades: ["Lima", "Callao", "San Juan de Lurigancho", "Miraflores", "Comas"]},
                            "LOR": {nombre: "Loreto", ciudades: ["Iquitos", "Yurimaguas", "Nauta"]},
                            "MDD": {nombre: "Madre de Dios", ciudades: ["Puerto Maldonado", "Iñapari", "Laberinto"]},
                            "MOQ": {nombre: "Moquegua", ciudades: ["Moquegua", "Ilo", "Omate"]},
                            "PAS": {nombre: "Pasco", ciudades: ["Cerro de Pasco", "Oxapampa", "Yanahuanca"]},
                            "PIU": {nombre: "Piura", ciudades: ["Piura", "Sullana", "Talara", "Paita"]},
                            "PUN": {nombre: "Puno", ciudades: ["Puno", "Juliaca", "Azángaro", "Ilave"]},
                            "SAM": {nombre: "San Martín", ciudades: ["Moyobamba", "Tarapoto", "Juanjuí"]},
                            "TAC": {nombre: "Tacna", ciudades: ["Tacna", "Alto de la Alianza", "Locumba"]},
                            "TUM": {nombre: "Tumbes", ciudades: ["Tumbes", "Zorritos", "Aguas Verdes"]},
                            "UCA": {nombre: "Ucayali", ciudades: ["Pucallpa", "Aguaytía", "Atalaya"]}
                        }
                    },
                    "US": {
                        nombre: "Estados Unidos",
                        estados: {
                            "AL": {nombre: "Alabama", ciudades: ["Birmingham", "Montgomery", "Mobile", "Huntsville"]},
                            "AK": {nombre: "Alaska", ciudades: ["Anchorage", "Fairbanks", "Juneau"]},
                            "AZ": {nombre: "Arizona", ciudades: ["Phoenix", "Tucson", "Mesa", "Scottsdale"]},
                            "AR": {nombre: "Arkansas", ciudades: ["Little Rock", "Fort Smith", "Fayetteville"]},
                            "CA": {nombre: "California", ciudades: ["Los Ángeles", "San Francisco", "San Diego", "Sacramento"]},
                            "CO": {nombre: "Colorado", ciudades: ["Denver", "Colorado Springs", "Aurora"]},
                            "CT": {nombre: "Connecticut", ciudades: ["Bridgeport", "New Haven", "Stamford", "Hartford"]},
                            "DE": {nombre: "Delaware", ciudades: ["Wilmington", "Dover", "Newark"]},
                            "FL": {nombre: "Florida", ciudades: ["Miami", "Orlando", "Tampa", "Jacksonville"]},
                            "GA": {nombre: "Georgia", ciudades: ["Atlanta", "Savannah", "Augusta", "Columbus"]},
                            "HI": {nombre: "Hawái", ciudades: ["Honolulu", "Hilo", "Kailua"]},
                            "ID": {nombre: "Idaho", ciudades: ["Boise", "Meridian", "Nampa"]},
                            "IL": {nombre: "Illinois", ciudades: ["Chicago", "Aurora", "Naperville", "Rockford"]},
                            "IN": {nombre: "Indiana", ciudades: ["Indianápolis", "Fort Wayne", "Evansville"]},
                            "IA": {nombre: "Iowa", ciudades: ["Des Moines", "Cedar Rapids", "Davenport"]},
                            "KS": {nombre: "Kansas", ciudades: ["Wichita", "Overland Park", "Kansas City"]},
                            "KY": {nombre: "Kentucky", ciudades: ["Louisville", "Lexington", "Bowling Green"]},
                            "LA": {nombre: "Luisiana", ciudades: ["Nueva Orleans", "Baton Rouge", "Shreveport"]},
                            "ME": {nombre: "Maine", ciudades: ["Portland", "Lewiston", "Bangor"]},
                            "MD": {nombre: "Maryland", ciudades: ["Baltimore", "Frederick", "Rockville"]},
                            "MA": {nombre: "Massachusetts", ciudades: ["Boston", "Worcester", "Springfield"]},
                            "MI": {nombre: "Michigan", ciudades: ["Detroit", "Grand Rapids", "Warren", "Ann Arbor"]},
                            "MN": {nombre: "Minnesota", ciudades: ["Minneapolis", "Saint Paul", "Rochester"]},
                            "MS": {nombre: "Misisipi", ciudades: ["Jackson", "Gulfport", "Southaven"]},
                            "MO": {nombre: "Misuri", ciudades: ["Kansas City", "San Luis", "Springfield"]},
                            "MT": {nombre: "Montana", ciudades: ["Billings", "Missoula", "Great Falls"]},
                            "NE": {nombre: "Nebraska", ciudades: ["Omaha", "Lincoln", "Bellevue"]},
                            "NV": {nombre: "Nevada", ciudades: ["Las Vegas", "Henderson", "Reno"]},
                            "NH": {nombre: "Nuevo Hampshire", ciudades: ["Manchester", "Nashua", "Concord"]},
                            "NJ": {nombre: "Nueva Jersey", ciudades: ["Newark", "Jersey City", "Paterson"]},
                            "NM": {nombre: "Nuevo México", ciudades: ["Albuquerque", "Santa Fe", "Las Cruces"]},
                            "NY": {nombre: "Nueva York", ciudades: ["Nueva York", "Buffalo", "Rochester", "Syracuse"]},
                            "NC": {nombre: "Carolina del Norte", ciudades: ["Charlotte", "Raleigh", "Greensboro"]},
                            "ND": {nombre: "Dakota del Norte", ciudades: ["Fargo", "Bismarck", "Grand Forks"]},
                            "OH": {nombre: "Ohio", ciudades: ["Columbus", "Cleveland", "Cincinnati", "Toledo"]},
                            "OK": {nombre: "Oklahoma", ciudades: ["Oklahoma City", "Tulsa", "Norman"]},
                            "OR": {nombre: "Oregón", ciudades: ["Portland", "Salem", "Eugene"]},
                            "PA": {nombre: "Pensilvania", ciudades: ["Filadelfia", "Pittsburgh", "Allentown"]},
                            "RI": {nombre: "Rhode Island", ciudades: ["Providence", "Warwick", "Cranston"]},
                            "SC": {nombre: "Carolina del Sur", ciudades: ["Charleston", "Columbia", "North Charleston"]},
                            "SD": {nombre: "Dakota del Sur", ciudades: ["Sioux Falls", "Rapid City", "Aberdeen"]},
                            "TN": {nombre: "Tennessee", ciudades: ["Nashville", "Memphis", "Knoxville", "Chattanooga"]},
                            "TX": {nombre: "Texas", ciudades: ["Houston", "Austin", "Dallas", "San Antonio", "Fort Worth"]},
                            "UT": {nombre: "Utah", ciudades: ["Salt Lake City", "West Valley City", "Provo"]},
                            "VT": {nombre: "Vermont", ciudades: ["Burlington", "Essex", "South Burlington"]},
                            "VA": {nombre: "Virginia", ciudades: ["Virginia Beach", "Norfolk", "Chesapeake"]},
                            "WA": {nombre: "Washington", ciudades: ["Seattle", "Spokane", "Tacoma"]},
                            "WV": {nombre: "Virginia Occidental", ciudades: ["Charleston", "Huntington", "Morgantown"]},
                            "WI": {nombre: "Wisconsin", ciudades: ["Milwaukee", "Madison", "Green Bay"]},
                            "WY": {nombre: "Wyoming", ciudades: ["Cheyenne", "Casper", "Laramie"]}
                        }
                    },
                    "CA": {
                        nombre: "Canadá",
                        estados: {
                            "ON": {nombre: "Ontario", ciudades: ["Toronto", "Ottawa", "Mississauga", "Brampton"]},
                            "QC": {nombre: "Quebec", ciudades: ["Montreal", "Quebec City", "Gatineau", "Laval"]},
                            "BC": {nombre: "Columbia Británica", ciudades: ["Vancouver", "Victoria", "Burnaby", "Richmond"]},
                            "AB": {nombre: "Alberta", ciudades: ["Calgary", "Edmonton", "Red Deer", "Lethbridge"]},
                            "MB": {nombre: "Manitoba", ciudades: ["Winnipeg", "Brandon", "Steinbach", "Portage la Prairie"]},
                            "SK": {nombre: "Saskatchewan", ciudades: ["Saskatoon", "Regina", "Prince Albert", "Moose Jaw"]},
                            "NS": {nombre: "Nueva Escocia", ciudades: ["Halifax", "Sydney", "Dartmouth", "Truro"]},
                            "NB": {nombre: "Nuevo Brunswick", ciudades: ["Fredericton", "Moncton", "Saint John", "Dieppe"]},
                            "NL": {nombre: "Terranova y Labrador", ciudades: ["St. John's", "Mount Pearl", "Corner Brook"]},
                            "PE": {nombre: "Isla del Príncipe Eduardo", ciudades: ["Charlottetown", "Summerside"]},
                            "NT": {nombre: "Territorios del Noroeste", ciudades: ["Yellowknife", "Hay River", "Inuvik"]},
                            "YT": {nombre: "Yukón", ciudades: ["Whitehorse", "Dawson City"]},
                            "NU": {nombre: "Nunavut", ciudades: ["Iqaluit", "Rankin Inlet"]}
                        }
                    },
                    "HT": {
                        nombre: "Haití",
                        estados: {
                            "OU": {nombre: "Ouest", ciudades: ["Puerto Príncipe", "Delmas", "Carrefour", "Petion-Ville"]},
                            "ND": {nombre: "Nord", ciudades: ["Cap-Haïtien", "Limonade", "Milot", "Acul-du-Nord"]},
                            "AR": {nombre: "Artibonite", ciudades: ["Gonaïves", "Saint-Marc", "Dessalines", "Gros-Morne"]},
                            "CE": {nombre: "Centre", ciudades: ["Hinche", "Mirebalais", "Lascahobas", "Belladère"]},
                            "SD": {nombre: "Sud", ciudades: ["Les Cayes", "Aquin", "Coteaux", "Port-Salut"]},
                            "NE": {nombre: "Nord-Est", ciudades: ["Fort-Liberté", "Ouanaminthe", "Trou-du-Nord", "Ferrier"]},
                            "NO": {nombre: "Nord-Ouest", ciudades: ["Port-de-Paix", "Saint-Louis du Nord", "Jean-Rabel", "Anse-à-Foleur"]},
                            "SE": {nombre: "Sud-Est", ciudades: ["Jacmel", "Marigot", "Cayes-Jacmel", "Belle-Anse"]},
                            "NI": {nombre: "Nippes", ciudades: ["Miragoâne", "Baradères", "Petite-Rivière-de-Nippes", "Anse-à-Veau"]},
                            "GD": {nombre: "Grand'Anse", ciudades: ["Jérémie", "Dame-Marie", "Anse-d'Hainault", "Les Irois"]}
                        }
                    },
                    "DO": {
                        nombre: "República Dominicana",
                        estados: {
                            "SD": {nombre: "Santo Domingo", ciudades: ["Santo Domingo", "Boca Chica", "Los Alcarrizos", "San Cristóbal"]},
                            "PN": {nombre: "La Altagracia", ciudades: ["Punta Cana", "Bávaro", "Verón", "Higüey"]},
                            "PR": {nombre: "Puerto Plata", ciudades: ["Puerto Plata", "Sosúa", "Cabarete", "Maimón"]},
                            "AS": {nombre: "Sánchez Ramírez", ciudades: ["Cotuí", "La Mata", "Cerro de Oro", "Jima Abajo"]},
                            "DN": {nombre: "Distrito Nacional", ciudades: ["Santo Domingo", "Los Alcarrizos", "La Zurza"]},
                            "SJ": {nombre: "San Juan", ciudades: ["San Juan de la Maguana", "Bohechío", "Las Matas de Farfán"]},
                            "BA": {nombre: "Barahona", ciudades: ["Barahona", "Neiba", "Cabral"]},
                            "EX": {nombre: "El Seibo", ciudades: ["El Seibo", "Pueblo Viejo", "La Higuera"]},
                            "MA": {nombre: "Maria Trinidad Sánchez", ciudades: ["Nagua", "Cabrera", "Sánchez"]},
                            "PR": {nombre: "Samaná", ciudades: ["Samaná", "Las Terrenas", "El Limón"]}
                        }
                    },
                    "SV": {
                        nombre: "El Salvador",
                        estados: {
                            "SS": {nombre: "San Salvador", ciudades: ["San Salvador", "Santa Tecla", "Soyapango", "Apopa"]},
                            "LA": {nombre: "La Libertad", ciudades: ["La Libertad", "El Tunco", "Antiguo Cuscatlán", "Santa Tecla"]},
                            "CH": {nombre: "Chalatenango", ciudades: ["Chalatenango", "La Palma", "San Ignacio"]},
                            "CUS": {nombre: "Cuscatlán", ciudades: ["Cojutepeque", "San Ramón", "Santa Cruz"]},
                            "LA": {nombre: "La Paz", ciudades: ["La Paz", "El Rosario", "San Pedro Perulapán"]},
                            "SAN": {nombre: "San Vicente", ciudades: ["San Vicente", "San Esteban Catarina", "Apastepeque"]},
                            "Ahu": {nombre: "Ahuachapán", ciudades: ["Ahuachapán", "El Sunza", "San Francisco Menéndez"]},
                            "SON": {nombre: "Sonsonate", ciudades: ["Sonsonate", "Juayúa", "Salcoatitán"]},
                            "MOR": {nombre: "Morazán", ciudades: ["San Francisco Gotera", "Perquín", "Corinto"]},
                            "SUC": {nombre: "Santa Ana", ciudades: ["Santa Ana", "Metapán", "El Congo"]}
                        }
                    },
                    "NI": {
                        nombre: "Nicaragua",
                        estados: {
                            "SG": {nombre: "Managua", ciudades: ["Managua", "Masaya", "Tipitapa", "Diriamba"]},
                            "LE": {nombre: "León", ciudades: ["León", "Chinandega", "El Viejo", "La Paz Centro"]},
                            "GR": {nombre: "Granada", ciudades: ["Granada", "Nandaime", "Diriomo", "San Francisco"]},
                            "CS": {nombre: "Carazo", ciudades: ["Diriamba", "La Conquista", "Masatepe", "San Marcos"]},
                            "SJ": {nombre: "San Juan", ciudades: ["San Juan del Sur", "San Juan de Oriente", "El Ostional"]},
                            "RI": {nombre: "Rivas", ciudades: ["Rivas", "San Jorge", "San Juan del Sur", "Tola"]},
                            "BZ": {nombre: "Boaco", ciudades: ["Boaco", "Camoapa", "San Lorenzo", "Santa Lucía"]},
                            "CA": {nombre: "Caldas", ciudades: ["Caldas", "San Ramón", "Matagalpa"]},
                            "MD": {nombre: "Matagalpa", ciudades: ["Matagalpa", "Jinotega", "San Ramón", "Esquipulas"]},
                            "NS": {nombre: "Nueva Segovia", ciudades: ["Jalapa", "Nueva Segovia", "Ocotal"]}
                        }
                    },
                    "GY": {
                        nombre: "Guyana",
                        estados: {
                            "DE": {nombre: "Demerara-Mahaica", ciudades: ["Georgetown", "Vreed-en-Hoop", "Diamond", "Beterverwagting"]},
                            "ES": {nombre: "Essequibo Islands-West Demerara", ciudades: ["Vreed-en-Hoop", "Bibiana", "Parika", "Good Hope"]},
                            "BA": {nombre: "Berbice", ciudades: ["New Amsterdam", "Rosignol", "Canje"]},
                            "PM": {nombre: "Pomeroon-Supenaam", ciudades: ["Anna Regina", "Cotton Field", "Suddie"]},
                            "MA": {nombre: "Mahaica-Berbice", ciudades: ["Rosignol", "New Amsterdam", "Number 43"]},
                            "CU": {nombre: "Cuyuni-Mazaruni", ciudades: ["Bartica", "Potaro-Siparuni", "Bovoni"]},
                            "UP": {nombre: "Upper Takutu-Upper Essequibo", ciudades: ["Lethem", "Surama", "Nappi"]},
                            "GE": {nombre: "Georgetown", ciudades: ["Georgetown", "Linden", "Kwakwani"]}
                        }
                    },
                    "SR": {
                        nombre: "Surinam",
                        estados: {
                            "PM": {nombre: "Paramaribo", ciudades: ["Paramaribo", "Commewijne", "Saramacca", "Marowijne"]},
                            "BR": {nombre: "Brokopondo", ciudades: ["Brokopondo", "Kopoldrie", "Apoera", "Nieuw Amsterdam"]},
                            "NI": {nombre: "Nickerie", ciudades: ["Nieuw Nickerie", "Blauwgrond", "Klein Kwartier"]},
                            "MA": {nombre: "Marowijne", ciudades: ["Albina", "Moengo", "Brownsweg"]},
                            "SI": {nombre: "Sipaliwini", ciudades: ["Jodensavanne", "Matawai", "Boven Saramacca", "Boven Para"]},
                            "HE": {nombre: "Para", ciudades: ["Paranam", "Kraft", "Lelydorp"]},
                            "CO": {nombre: "Coronie", ciudades: ["Coronie", "Totness", "Nickerie"]},
                            "WA": {nombre: "Wanica", ciudades: ["Lelydorp", "Houttuin", "Tamanredjo"]}
                        }
                    },
                    "BB": {
                        nombre: "Barbados",
                        estados: {
                            "CH": {nombre: "Christ Church", ciudades: ["Bridgetown", "Oistins", "Dover", "Drax Hall"]},
                            "ST": {nombre: "Saint Thomas", ciudades: ["Saint Thomas", "Speightstown", "Holetown", "Welches"]},
                            "ST": {nombre: "Saint John", ciudades: ["Saint John", "Bathsheba", "Mount Clair", "Boscobel"]},
                            "SN": {nombre: "Saint Nicholas", ciudades: ["Saint Nicholas", "Silver Sands", "Crane"]},
                            "ST": {nombre: "Saint George", ciudades: ["Saint George", "Mackenson", "Tamarind Hall"]},
                            "PG": {nombre: "Saint Peter", ciudades: ["Saint Peter", "Speightstown", "Mullins"]},
                            "PS": {nombre: "Saint Philip", ciudades: ["Saint Philip", "Six Roads", "Brighton"]},
                            "CC": {nombre: "Saint Lucy", ciudades: ["Saint Lucy", "Foul Bay", "Little Good Harbour"]}
                        }
                    },
                    "JM": {
                        nombre: "Jamaica",
                        estados: {
                            "KG": {nombre: "Kingston", ciudades: ["Kingston", "Spanish Town", "Montego Bay", "Mandeville"]},
                            "ST": {nombre: "Saint Andrew", ciudades: ["Half Way Tree", "Papine", "Liguanea", "New Kingston"]},
                            "CC": {nombre: "Clarendon", ciudades: ["May Pen", "Glenmuir", "Kensington"]},
                            "CM": {nombre: "Cornwall", ciudades: ["Montego Bay", "Falmouth", "Lucea"]},
                            "ST": {nombre: "Saint James", ciudades: ["Montego Bay", "Ironshore", "Rose Hall"]},
                            "ST": {nombre: "Saint Catherine", ciudades: ["Spanish Town", "Portmore", "Old Harbour"]},
                            "ST": {nombre: "Saint Mary", ciudades: ["Port Maria", "Oracabessa", "Boscobel"]},
                            "ST": {nombre: "Saint Ann", ciudades: ["Ocho Rios", "Runaway Bay", "Brown's Town"]},
                            "ST": {nombre: "Trelawny", ciudades: ["Falmouth", "Duncans", "Martha Brae"]},
                            "ST": {nombre: "Hanover", ciudades: ["Lucea", "Green Island", "Sandy Bay"]},
                            "ST": {nombre: "Westmoreland", ciudades: ["Savanna-la-Mar", "Negril", "Whitehouse"]},
                            "ST": {nombre: "St. Elizabeth", ciudades: ["Black River", "Santa Cruz", "Malvern"]},
                            "ST": {nombre: "Manchester", ciudades: ["Mandeville", "Christiana", "Knockpatrick"]}
                        }
                    },
                    "AG": {
                        nombre: "Antigua y Barbuda",
                        estados: {
                            "AN": {nombre: "Antigua", ciudades: ["Saint John's", "All Saints", "Liberta", "English Harbour"]},
                            "BAR": {nombre: "Barbuda", ciudades: ["Codrington"]}
                        }
                    },
                    "AW": {
                        nombre: "Aruba",
                        estados: {
                            "AR": {nombre: "Aruba", ciudades: ["Oranjestad", "San Nicolaas", "Noord", "Paradera"]}
                        }
                    },
                    "BS": {
                        nombre: "Bahamas",
                        estados: {
                            "Nassau": {nombre: "Nassau", ciudades: ["Nassau", "Freeport", "Marsh Harbour", "Andros Town"]}
                        }
                    },
                    "CU": {
                        nombre: "Cuba",
                        estados: {
                            "HA": {nombre: "La Habana", ciudades: ["La Habana", "Mariel", "Guanabo", "Santa María del Mar"]},
                            "PI": {nombre: "Pinar del Río", ciudades: ["Pinar del Río", "Viñales", "San Luis", "La Palma"]}
                        }
                    },
                    "DM": {
                        nombre: "Dominica",
                        estados: {
                            "ST": {nombre: "Saint George", ciudades: ["Roseau", "Portsmouth", "Berekua", "Salisbury"]}
                        }
                    },
                    "GD": {
                        nombre: "Grenada",
                        estados: {
                            "ST": {nombre: "Saint George", ciudades: ["St. George's", "Grenville", "Carriacou", "Lance aux Epines"]}
                        }
                    },
                    "GP": {
                        nombre: "Guadalupe",
                        estados: {
                            "BA": {nombre: "Basse-Terre", ciudades: ["Basse-Terre", "Les Abymes", "Baie-Mahault", "Petit-Bourg"]}
                        }
                    },
                    "KY": {
                        nombre: "Islas Caimán",
                        estados: {
                            "GR": {nombre: "Gran Caimán", ciudades: ["George Town", "West Bay", "Bodden Town", "Little Cayman"]}
                        }
                    },
                    "TC": {
                        nombre: "Islas Turcas y Caicos",
                        estados: {
                            "GR": {nombre: "Grand Turk", ciudades: ["Cockburn Town", "Pine Cay", "North Caicos", "South Caicos"]}
                        }
                    },
                    "VI": {
                        nombre: "Islas Vírgenes",
                        estados: {
                            "VG": {nombre: "Islas Vírgenes Británicas", ciudades: ["Road Town", "Tortola", "Virgin Gorda", "Anegada"]},
                            "US": {nombre: "Islas Vírgenes de los Estados Unidos", ciudades: ["Charlotte Amalie", "Tortola", "Cruz Bay", "Frederiksted"]}
                        }
                    },
                    "LC": {
                        nombre: "Santa Lucía",
                        estados: {
                            "CA": {nombre: "Castries", ciudades: ["Castries", "Vieux Fort", "Gros Islet", "Soufrière"]}
                        }
                    },
                    "TT": {
                        nombre: "Trinidad y Tobago",
                        estados: {
                            "PD": {nombre: "Puerto España", ciudades: ["Puerto España", "San Fernando", "Chaguanas", "Point Fortin"]}
                        }
                    },
                    "BZ": {
                        nombre: "Belice",
                        estados: {
                            "BZ": {nombre: "Belice", ciudades: ["Belmopan", "Ciudad de Belice", "San Ignacio", "Corozal"]}
                        }
                    },
                    "GT": {
                        nombre: "Guatemala",
                        estados: {
                            "GU": {nombre: "Guatemala", ciudades: ["Ciudad de Guatemala", "Mixco", "Villa Nueva", "Quetzaltenango"]}
                        }
                    },
                    "HN": {
                        nombre: "Honduras",
                        estados: {
                            "FM": {nombre: "Francisco Morazán", ciudades: ["Tegucigalpa", "Comayagua", "Valle de Ángeles", "La Paz"]},
                            "CC": {nombre: "Cortés", ciudades: ["San Pedro Sula", "Choloma", "Puerto Cortés", "La Lima"]}
                        }
                    },
                    "RU": {
                        nombre: "Rusia",
                        estados: {
                            "MOW": {nombre: "Moscú", ciudades: ["Moscú", "Khimki", "Balashikha", "Podolsk"]},
                            "LEN": {nombre: "San Petersburgo", ciudades: ["San Petersburgo", "Svetogorsk", "Gatchina", "Pushkin"]}
                        }
                    },
                    "DE": {
                        nombre: "Alemania",
                        estados: {
                            "BE": {nombre: "Berlín", ciudades: ["Berlín", "Potsdam", "Brandenburgo"]},
                            "BY": {nombre: "Baviera", ciudades: ["Múnich", "Núremberg", "Augsburgo", "Regensburg"]}
                        }
                    },
                    "GB": {
                        nombre: "Reino Unido",
                        estados: {
                            "ENG": {nombre: "Inglaterra", ciudades: ["Londres", "Birmingham", "Mánchester", "Liverpool"]},
                            "SCT": {nombre: "Escocia", ciudades: ["Edimburgo", "Glasgow", "Aberdeen", "Dundee"]}
                        }
                    },
                    "FR": {
                        nombre: "Francia",
                        estados: {
                            "IDF": {nombre: "Île-de-France", ciudades: ["París", "Versalles", "Saint-Denis", "Créteil"]},
                            "PAC": {nombre: "Provenza-Alpes-Costa Azul", ciudades: ["Niza", "Marsella", "Aix-en-Provence", "Toulon"]}
                        }
                    },
                    "IT": {
                        nombre: "Italia",
                        estados: {
                            "LAZ": {nombre: "Lacio", ciudades: ["Roma", "Fiumicino", "Civitavecchia", "Tivoli"]},
                            "LIG": {nombre: "Liguria", ciudades: ["Génova", "La Spezia", "San Remo", "Savona"]}
                        }
                    },
                    "UA": {
                        nombre: "Ucrania",
                        estados: {
                            "KY": {nombre: "Kiev", ciudades: ["Kiev", "Brovary", "Irpín", "Vasilkiv"]},
                            "OD": {nombre: "Odesa", ciudades: ["Odesa", "Izmaíl", "Bilhorod-Dnistrovskyi", "Biliaivka"]}
                        }
                    },
                    "PL": {
                        nombre: "Polonia",
                        estados: {
                            "MA": {nombre: "Małopolskie", ciudades: ["Cracovia", "Tarnów", "Nowy Sącz", "Wadowice"]},
                            "SL": {nombre: "Silesia", ciudades: ["Katowice", "Gliwice", "Zabrze", "Bytom"]}
                        }
                    },
                    "RO": {
                        nombre: "Rumania",
                        estados: {
                            "BU": {nombre: "Bucarest", ciudades: ["Bucarest", "Ploiești", "Bucureștii Noi", "Berceni"]},
                            "TM": {nombre: "Timiș", ciudades: ["Timișoara", "Reșița", "Lugoj", "Sânnicolau Mare"]}
                        }
                    },
                    "NL": {
                        nombre: "Países Bajos",
                        estados: {
                            "NH": {nombre: "Holanda del Norte", ciudades: ["Ámsterdam", "Haarlem", "Zaanstad", "Almere"]},
                            "ZH": {nombre: "Holanda del Sur", ciudades: ["Róterdam", "La Haya", "Delft", "Leiden"]}
                        }
                    },
                    "BE": {
                        nombre: "Bélgica",
                        estados: {
                            "BRU": {nombre: "Bruselas", ciudades: ["Bruselas", "Ixelles", "Saint-Gilles", "Anderlecht"]},
                            "VLA": {nombre: "Flandes", ciudades: ["Gante", "Brujas", "Amberes", "Ostende"]}
                        }
                    },
                    "CZ": {
                        nombre: "República Checa",
                        estados: {
                            "PR": {nombre: "Praga", ciudades: ["Praga", "České Budějovice", "Plzeň", "Ústí nad Labem"]}
                        }
                    },
                    "SE": {
                        nombre: "Suecia",
                        estados: {
                            "ST": {nombre: "Estocolmo", ciudades: ["Estocolmo", "Sundbyberg", "Solna", "Nacka"]},
                            "VG": {nombre: "Västra Götaland", ciudades: ["Gotenburgo", "Borås", "Alingsås", "Kungälv"]}
                        }
                    },
                    "GR": {
                        nombre: "Grecia",
                        estados: {
                            "AT": {nombre: "Ática", ciudades: ["Atenas", "Pireo", "Maratón", "Kifisia"]},
                            "MA": {nombre: "Macedonia", ciudades: ["Salónica", "Katerini", "Edessa", "Kozani"]}
                        }
                    },
                    "PT": {
                        nombre: "Portugal",
                        estados: {
                            "LP": {nombre: "Lisboa", ciudades: ["Lisboa", "Sintra", "Cascais", "Setúbal"]},
                            "PR": {nombre: "Oporto", ciudades: ["Oporto", "Vila Nova de Gaia", "Maia", "Matosinhos"]}
                        }
                    },
                    "HU": {
                        nombre: "Hungría",
                        estados: {
                            "BU": {nombre: "Budapest", ciudades: ["Budapest", "Szentendre", "Érd", "Budaörs"]}
                        }
                    },
                    "BY": {
                        nombre: "Bielorrusia",
                        estados: {
                            "MI": {nombre: "Minsk", ciudades: ["Minsk", "Zhodino", "Lida", "Salihorsk"]}
                        }
                    },
                    "AT": {
                        nombre: "Austria",
                        estados: {
                            "WI": {nombre: "Viena", ciudades: ["Viena", "Graz", "Linz", "Salzburgo"]}
                        }
                    },
                    "CH": {
                        nombre: "Suiza",
                        estados: {
                            "GE": {nombre: "Ginebra", ciudades: ["Ginebra", "Carouge", "Lancy", "Meyrin"]},
                            "ZH": {nombre: "Zúrich", ciudades: ["Zúrich", "Winterthur", "Uster", "Dübendorf"]}
                        }
                    }
                };


                const selectPais = document.getElementById('pais');
                const selectEstado = document.getElementById('estado');
                const selectCiudad = document.getElementById('ciudad');

                // Cargar países en el select de país
                Object.keys(datosPaises).forEach(codigoPais => {
                    const pais = datosPaises[codigoPais];
                    const option = document.createElement('option');
                    option.value = codigoPais;
                    option.textContent = pais.nombre;
                    selectPais.appendChild(option);
                });

                // Cargar estados cuando se selecciona un país
                selectPais.addEventListener('change', function () {
                    selectEstado.innerHTML = '<option value="">Selecciona tu estado</option>';
                    selectCiudad.innerHTML = '<option value="">Selecciona tu ciudad</option>';

                    const paisSeleccionado = datosPaises[selectPais.value];
                    if (paisSeleccionado) {
                        Object.keys(paisSeleccionado.estados).forEach(codigoEstado => {
                            const estado = paisSeleccionado.estados[codigoEstado];
                            const option = document.createElement('option');
                            option.value = codigoEstado;
                            option.textContent = estado.nombre;
                            selectEstado.appendChild(option);
                        });
                    }
                });

                // Cargar ciudades cuando se selecciona un estado
                selectEstado.addEventListener('change', function () {
                    selectCiudad.innerHTML = '<option value="">Selecciona tu ciudad</option>';

                    const estadoSeleccionado = datosPaises[selectPais.value]?.estados[selectEstado.value];
                    if (estadoSeleccionado) {
                        estadoSeleccionado.ciudades.forEach(ciudad => {
                            const option = document.createElement('option');
                            option.value = ciudad;
                            option.textContent = ciudad;
                            selectCiudad.appendChild(option);
                        });
                    }
                });

                // Función para mostrar errores
                function mostrarError(elementId, mensaje) {
                    const errorElement = document.getElementById(elementId + 'Error');
                    if (errorElement) {
                        errorElement.textContent = mensaje;
                        errorElement.style.color = 'red';
                    }
                }

                // Función para limpiar errores
                function limpiarError(elementId) {
                    const errorElement = document.getElementById(elementId + 'Error');
                    if (errorElement) {
                        errorElement.textContent = '';
                    }
                }

                // Función para validar email
                function validarEmail(email) {
                    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    return regex.test(email);
                }

                // Función para validar contraseña
                function validarPassword(password) {
                    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
                    return regex.test(password);
                }

                // Función para validar fecha de nacimiento
                function validarFechaNacimiento(fecha) {
                    const hoy = new Date();
                    const fechaNacimiento = new Date(fecha);
                    const edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
                    return edad >= 10;
                }

                // Función para validar teléfono
                function validarTelefono(telefono) {
                    const regex = /^[0-9]{10}$/;
                    return regex.test(telefono);
                }

                // Manejador de envío del formulario
                document.getElementById('registroForm').addEventListener('submit', function (event) {
                    event.preventDefault();

                    let errores = false;

                    const nombre = document.getElementById('nombre').value;
                    const email = document.getElementById('email').value;
                    const password = document.getElementById('password').value;
                    const fechaNacimiento = document.getElementById('fechaNacimiento').value;
                    const telefono = document.getElementById('telefono').value;

                    limpiarError('nombre');
                    limpiarError('email');
                    limpiarError('password');
                    limpiarError('fechaNacimiento');
                    limpiarError('telefono');

                    if (nombre.trim() === '') {
                        mostrarError('nombre', 'El nombre es obligatorio');
                        errores = true;
                    }
                    if (!validarEmail(email)) {
                        mostrarError('email', 'Correo electrónico no válido');
                        errores = true;
                    }
                    if (!validarPassword(password)) {
                        mostrarError('password', 'La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número');
                        errores = true;
                    }
                    if (!validarFechaNacimiento(fechaNacimiento)) {
                        mostrarError('fechaNacimiento', 'Debes ser mayor de 10 años');
                        errores = true;
                    }
                    if (!validarTelefono(telefono)) {
                        mostrarError('telefono', 'El teléfono debe tener 10 dígitos numéricos');
                        errores = true;
                    }

                    if (!errores) {
                        // Guardar el usuario en localStorage
                        const usuarios = JSON.parse(localStorage.getItem('usuarios') || '[]');
                        usuarios.push({nombre, email, password, fechaNacimiento, telefono});
                        localStorage.setItem('usuarios', JSON.stringify(usuarios));

                        alert('Registro exitoso');
                        document.getElementById('registroForm').reset(); // Limpiar el formulario
                        window.location.href = 'index.html'; // Redirigir a index.html
                    }
                });
            });
        </script>  

    </body>
</html>
