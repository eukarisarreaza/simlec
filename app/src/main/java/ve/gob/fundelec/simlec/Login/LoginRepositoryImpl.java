package ve.gob.fundelec.simlec.Login;


import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.CentroLectura;
import ve.gob.fundelec.simlec.DataBase.entities.Estados;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura;
import ve.gob.fundelec.simlec.DataBase.entities.FRuta;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.Municipios;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Login.event.LoginEvent;
import ve.gob.fundelec.simlec.Services.ServiceRequest;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginRepositoryImpl implements LoginRepository{
    private static final String TAG= LoginRepositoryImpl.class.getName();
    private EventBus eventBus;
    private ServiceRequest request;
    private LectorSessionManager sessionManager;

    public LoginRepositoryImpl(EventBus eventBus, ServiceRequest request, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.request = request;
        this.sessionManager = sessionManager;
    }

    @Override
    public void login(String type, String user, String password) {
        /** crear data de inicio */
        // validar que no esten vacios los campos o sena nulos
        if(type.isEmpty() || user.isEmpty() || password.isEmpty())
            postEvent(LoginEvent.onLoginError, "");
        else {

            new Thread(() -> {
                cargarDatosIncio();
                sessionManager.setLogged();
                postEvent(LoginEvent.onLoginSuccess, "");
            }).start();

        }
    }

    @Override
    public void checkForAuthenticateUser() {
        if(sessionManager.getLogged()){
            postEvent(LoginEvent.isLogeed, "");
        }
    }


    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent= new LoginEvent();
        loginEvent.setEventType(type);
        if(errorMessage != null){
            loginEvent.setErrorMessage(errorMessage);
        }
        eventBus.postSticky(loginEvent);
    }

    private void cargarDatosIncio() {
        /** SERAN SOLO DATOS DE PRUEBAS */
        setFNotasLectura();
        setFRuta();
        setCalleRuta();
        setCentroLectura();
        setEstados();
        setIndicadoresLectura();
        setLector();
        setMedidores();
        setMunicipios();
        setObjetoConexion();
        setParroquias();
        setProgamacionCalle();
        setRutas();
    }

    private void setRutas() {
        /**
         * (int id, int id_edo_ruta, int id_centro_lectura, int id_dispositivo_movil,
         String cod_ruta, String nom_ruta, String cod_status, int version, int accion)
         */
        Ruta ruta= new Ruta(1,1,1, 152, "SRA44014", "SRA44014", "", 1, 1);
        ruta.save();
    }

    private void setProgamacionCalle() {
        ProgramacionCalle progcalle1=new ProgramacionCalle(1,"2017-05-29",1,2,"2017-05-29",1,1,1,3,1);
        progcalle1.save();
        ProgramacionCalle progcalle2=new ProgramacionCalle(2,"2017-05-29",1,2,"2017-05-29",2,1,1,6,4);
        progcalle2.save();



    }

    private void setParroquias() {

        Parroquias parroquia1=new Parroquias("1",1,"Alto Orinoco",1,1); parroquia1.save();
        Parroquias parroquia2=new Parroquias("2",1,"Huachamacare Acanaña",1,1); parroquia2.save();
        Parroquias parroquia3=new Parroquias("3",1,"Marawaka Toky Shamanaña",1,1); parroquia3.save();
        Parroquias parroquia4=new Parroquias("4",1,"Mavaka Mavaka",1,1); parroquia4.save();
        Parroquias parroquia5=new Parroquias("5",1,"Sierra Parima Parimabé",1,1); parroquia5.save();
        Parroquias parroquia6=new Parroquias("6",2,"Ucata Laja Lisa",1,1); parroquia6.save();
        Parroquias parroquia7=new Parroquias("7",2,"Yapacana Macuruco",1,1); parroquia7.save();
        Parroquias parroquia8=new Parroquias("8",2,"Caname Guarinuma",1,1); parroquia8.save();
        Parroquias parroquia9=new Parroquias("9",3,"Fernando Girón Tovar",1,1); parroquia9.save();
        Parroquias parroquia10=new Parroquias("10",3,"Luis Alberto Gómez",1,1); parroquia10.save();
        Parroquias parroquia11=new Parroquias("11",3,"Pahueña Limón de Parhueña",1,1); parroquia11.save();
        Parroquias parroquia12=new Parroquias("12",3,"Platanillal Platanillal",1,1); parroquia12.save();
        Parroquias parroquia13=new Parroquias("13",4,"Samariapo",1,1); parroquia13.save();
        Parroquias parroquia14=new Parroquias("14",4,"Sipapo",1,1); parroquia14.save();
        Parroquias parroquia15=new Parroquias("15",4,"Munduapo",1,1); parroquia15.save();
        Parroquias parroquia16=new Parroquias("16",4,"Guayapo",1,1); parroquia16.save();
        Parroquias parroquia17=new Parroquias("17",5,"Alto Ventuari",1,1); parroquia17.save();
        Parroquias parroquia18=new Parroquias("18",5,"Medio Ventuari",1,1); parroquia18.save();
        Parroquias parroquia19=new Parroquias("19",5,"Bajo Ventuari",1,1); parroquia19.save();
        Parroquias parroquia20=new Parroquias("20",6,"Victorino",1,1); parroquia20.save();
        Parroquias parroquia21=new Parroquias("21",6,"Comunidad",1,1); parroquia21.save();
        Parroquias parroquia22=new Parroquias("22",7,"Casiquiare",1,1); parroquia22.save();
        Parroquias parroquia23=new Parroquias("23",7,"Cocuy",1,1); parroquia23.save();
        Parroquias parroquia24=new Parroquias("24",7,"San Carlos de Río Negro",1,1); parroquia24.save();
        Parroquias parroquia25=new Parroquias("25",7,"Solano",1,1); parroquia25.save();
        Parroquias parroquia26=new Parroquias("26",8,"Anaco",1,1); parroquia26.save();
        Parroquias parroquia27=new Parroquias("27",8,"San Joaquín",1,1); parroquia27.save();
        Parroquias parroquia28=new Parroquias("28",9,"Cachipo",1,1); parroquia28.save();
        Parroquias parroquia29=new Parroquias("29",9,"Aragua de Barcelona",1,1); parroquia29.save();
        Parroquias parroquia30=new Parroquias("30",11,"Lechería",1,1); parroquia30.save();
        Parroquias parroquia31=new Parroquias("31",11,"El Morro",1,1); parroquia31.save();
        Parroquias parroquia32=new Parroquias("32",12,"Puerto Píritu",1,1); parroquia32.save();
        Parroquias parroquia33=new Parroquias("33",12,"San Miguel",1,1); parroquia33.save();
        Parroquias parroquia34=new Parroquias("34",12,"Sucre",1,1); parroquia34.save();
        Parroquias parroquia35=new Parroquias("35",13,"Valle de Guanape",1,1); parroquia35.save();
        Parroquias parroquia36=new Parroquias("36",13,"Santa Bárbara",1,1); parroquia36.save();
        Parroquias parroquia37=new Parroquias("37",14,"El Chaparro",1,1); parroquia37.save();
        Parroquias parroquia38=new Parroquias("38",14,"Tomás Alfaro",1,1); parroquia38.save();
        Parroquias parroquia39=new Parroquias("39",14,"Calatrava",1,1); parroquia39.save();
        Parroquias parroquia40=new Parroquias("40",15,"Guanta",1,1); parroquia40.save();
        Parroquias parroquia41=new Parroquias("41",15,"Chorrerón",1,1); parroquia41.save();
        Parroquias parroquia42=new Parroquias("42",16,"Mamo",1,1); parroquia42.save();
        Parroquias parroquia43=new Parroquias("43",16,"Soledad",1,1); parroquia43.save();
        Parroquias parroquia44=new Parroquias("44",17,"Mapire",1,1); parroquia44.save();
        Parroquias parroquia45=new Parroquias("45",17,"Piar",1,1); parroquia45.save();
        Parroquias parroquia46=new Parroquias("46",17,"Santa Clara",1,1); parroquia46.save();
        Parroquias parroquia47=new Parroquias("47",17,"San Diego de Cabrutica",1,1); parroquia47.save();
        Parroquias parroquia48=new Parroquias("48",17,"Uverito",1,1); parroquia48.save();
        Parroquias parroquia49=new Parroquias("49",17,"Zuata",1,1); parroquia49.save();
        Parroquias parroquia50=new Parroquias("50",18,"Puerto La Cruz",1,1); parroquia50.save();
        Parroquias parroquia51=new Parroquias("51",18,"Pozuelos",1,1); parroquia51.save();
        Parroquias parroquia52=new Parroquias("52",19,"Onoto",1,1); parroquia52.save();
        Parroquias parroquia53=new Parroquias("53",19,"San Pablo",1,1); parroquia53.save();
        Parroquias parroquia54=new Parroquias("54",20,"San Mateo",1,1); parroquia54.save();
        Parroquias parroquia55=new Parroquias("55",20,"El Carito",1,1); parroquia55.save();
        Parroquias parroquia56=new Parroquias("56",20,"Santa Inés",1,1); parroquia56.save();
        Parroquias parroquia57=new Parroquias("57",20,"La Romereña",1,1); parroquia57.save();
        Parroquias parroquia58=new Parroquias("58",21,"Atapirire",1,1); parroquia58.save();
        Parroquias parroquia59=new Parroquias("59",21,"Boca del Pao",1,1); parroquia59.save();
        Parroquias parroquia60=new Parroquias("60",21,"El Pao",1,1); parroquia60.save();
        Parroquias parroquia61=new Parroquias("61",21,"Pariaguán",1,1); parroquia61.save();
        Parroquias parroquia62=new Parroquias("62",22,"Cantaura",1,1); parroquia62.save();
        Parroquias parroquia63=new Parroquias("63",22,"Libertador",1,1); parroquia63.save();
        Parroquias parroquia64=new Parroquias("64",22,"Santa Rosa",1,1); parroquia64.save();
        Parroquias parroquia65=new Parroquias("65",22,"Urica",1,1); parroquia65.save();
        Parroquias parroquia66=new Parroquias("66",23,"Píritu",1,1); parroquia66.save();
        Parroquias parroquia67=new Parroquias("67",23,"San Francisco",1,1); parroquia67.save();
        Parroquias parroquia68=new Parroquias("68",24,"San José de Guanipa",1,1); parroquia68.save();
        Parroquias parroquia69=new Parroquias("69",25,"Boca de Uchire",1,1); parroquia69.save();
        Parroquias parroquia70=new Parroquias("70",25,"Boca de Chávez",1,1); parroquia70.save();
        Parroquias parroquia71=new Parroquias("71",26,"Pueblo Nuevo",1,1); parroquia71.save();
        Parroquias parroquia72=new Parroquias("72",26,"Santa Ana",1,1); parroquia72.save();
        Parroquias parroquia73=new Parroquias("73",27,"Bergantín",1,1); parroquia73.save();
        Parroquias parroquia74=new Parroquias("74",27,"Caigua",1,1); parroquia74.save();
        Parroquias parroquia75=new Parroquias("75",27,"El Carmen",1,1); parroquia75.save();
        Parroquias parroquia76=new Parroquias("76",27,"El Pilar",1,1); parroquia76.save();
        Parroquias parroquia77=new Parroquias("77",27,"Naricual",1,1); parroquia77.save();
        Parroquias parroquia78=new Parroquias("78",27,"San Crsitóbal",1,1); parroquia78.save();
        Parroquias parroquia79=new Parroquias("79",28,"Edmundo Barrios",1,1); parroquia79.save();
        Parroquias parroquia80=new Parroquias("80",28,"Miguel Otero Silva",1,1); parroquia80.save();
        Parroquias parroquia81=new Parroquias("81",29,"Achaguas",1,1); parroquia81.save();
        Parroquias parroquia82=new Parroquias("82",29,"Apurito",1,1); parroquia82.save();
        Parroquias parroquia83=new Parroquias("83",29,"El Yagual",1,1); parroquia83.save();
        Parroquias parroquia84=new Parroquias("84",29,"Guachara",1,1); parroquia84.save();
        Parroquias parroquia85=new Parroquias("85",29,"Mucuritas",1,1); parroquia85.save();
        Parroquias parroquia86=new Parroquias("86",29,"Queseras del medio",1,1); parroquia86.save();
        Parroquias parroquia87=new Parroquias("87",30,"Biruaca",1,1); parroquia87.save();
        Parroquias parroquia88=new Parroquias("88",31,"Bruzual",1,1); parroquia88.save();
        Parroquias parroquia89=new Parroquias("89",31,"Mantecal",1,1); parroquia89.save();
        Parroquias parroquia90=new Parroquias("90",31,"Quintero",1,1); parroquia90.save();
        Parroquias parroquia91=new Parroquias("91",31,"Rincón Hondo",1,1); parroquia91.save();
        Parroquias parroquia92=new Parroquias("92",31,"San Vicente",1,1); parroquia92.save();
        Parroquias parroquia93=new Parroquias("93",32,"Guasdualito",1,1); parroquia93.save();
        Parroquias parroquia94=new Parroquias("94",32,"Aramendi",1,1); parroquia94.save();
        Parroquias parroquia95=new Parroquias("95",32,"El Amparo",1,1); parroquia95.save();
        Parroquias parroquia96=new Parroquias("96",32,"San Camilo",1,1); parroquia96.save();
        Parroquias parroquia97=new Parroquias("97",32,"Urdaneta",1,1); parroquia97.save();
        Parroquias parroquia98=new Parroquias("98",33,"San Juan de Payara",1,1); parroquia98.save();
        Parroquias parroquia99=new Parroquias("99",33,"Codazzi",1,1); parroquia99.save();
        Parroquias parroquia100=new Parroquias("100",33,"Cunaviche",1,1); parroquia100.save();
        Parroquias parroquia101=new Parroquias("101",34,"Elorza",1,1); parroquia101.save();
        Parroquias parroquia102=new Parroquias("102",34,"La Trinidad",1,1); parroquia102.save();
        Parroquias parroquia103=new Parroquias("103",35,"San Fernando",1,1); parroquia103.save();
        Parroquias parroquia104=new Parroquias("104",35,"El Recreo",1,1); parroquia104.save();
        Parroquias parroquia105=new Parroquias("105",35,"Peñalver",1,1); parroquia105.save();
        Parroquias parroquia106=new Parroquias("106",35,"San Rafael de Atamaica",1,1); parroquia106.save();
        Parroquias parroquia107=new Parroquias("107",36,"Pedro José Ovalles",1,1); parroquia107.save();
        Parroquias parroquia108=new Parroquias("108",36,"Joaquín Crespo",1,1); parroquia108.save();
        Parroquias parroquia109=new Parroquias("109",36,"José Casanova Godoy",1,1); parroquia109.save();
        Parroquias parroquia110=new Parroquias("110",36,"Madre María de San José",1,1); parroquia110.save();
        Parroquias parroquia111=new Parroquias("111",36,"Andrés Eloy Blanco",1,1); parroquia111.save();
        Parroquias parroquia112=new Parroquias("112",36,"Los Tacarigua",1,1); parroquia112.save();
        Parroquias parroquia113=new Parroquias("113",36,"Las Delicias",1,1); parroquia113.save();
        Parroquias parroquia114=new Parroquias("114",36,"Choroní",1,1); parroquia114.save();
        Parroquias parroquia115=new Parroquias("115",37,"Bolívar",1,1); parroquia115.save();
        Parroquias parroquia116=new Parroquias("116",38,"Camatagua",1,1); parroquia116.save();
        Parroquias parroquia117=new Parroquias("117",38,"Carmen de Cura",1,1); parroquia117.save();
        Parroquias parroquia118=new Parroquias("118",39,"Santa Rita",1,1); parroquia118.save();
        Parroquias parroquia119=new Parroquias("119",39,"Francisco de Miranda",1,1); parroquia119.save();
        Parroquias parroquia120=new Parroquias("120",39,"Moseñor Feliciano González",1,1); parroquia120.save();
        Parroquias parroquia121=new Parroquias("121",40,"Santa Cruz",1,1); parroquia121.save();
        Parroquias parroquia122=new Parroquias("122",41,"José Félix Ribas",1,1); parroquia122.save();
        Parroquias parroquia123=new Parroquias("123",41,"Castor Nieves Ríos",1,1); parroquia123.save();
        Parroquias parroquia124=new Parroquias("124",41,"Las Guacamayas",1,1); parroquia124.save();
        Parroquias parroquia125=new Parroquias("125",41,"Pao de Zárate",1,1); parroquia125.save();
        Parroquias parroquia126=new Parroquias("126",41,"Zuata",1,1); parroquia126.save();
        Parroquias parroquia127=new Parroquias("127",42,"José Rafael Revenga",1,1); parroquia127.save();
        Parroquias parroquia128=new Parroquias("128",43,"Palo Negro",1,1); parroquia128.save();
        Parroquias parroquia129=new Parroquias("129",43,"San Martín de Porres",1,1); parroquia129.save();
        Parroquias parroquia130=new Parroquias("130",44,"El Limón",1,1); parroquia130.save();
        Parroquias parroquia131=new Parroquias("131",44,"Caña de Azúcar",1,1); parroquia131.save();
        Parroquias parroquia132=new Parroquias("132",45,"Ocumare de la Costa",1,1); parroquia132.save();
        Parroquias parroquia133=new Parroquias("133",46,"San Casimiro",1,1); parroquia133.save();
        Parroquias parroquia134=new Parroquias("134",46,"Güiripa",1,1); parroquia134.save();
        Parroquias parroquia135=new Parroquias("135",46,"Ollas de Caramacate",1,1); parroquia135.save();
        Parroquias parroquia136=new Parroquias("136",46,"Valle Morín",1,1); parroquia136.save();
        Parroquias parroquia137=new Parroquias("137",47,"San Sebastían",1,1); parroquia137.save();
        Parroquias parroquia138=new Parroquias("138",48,"Turmero",1,1); parroquia138.save();
        Parroquias parroquia139=new Parroquias("139",48,"Arevalo Aponte",1,1); parroquia139.save();
        Parroquias parroquia140=new Parroquias("140",48,"Chuao",1,1); parroquia140.save();
        Parroquias parroquia141=new Parroquias("141",48,"Samán de Güere",1,1); parroquia141.save();
        Parroquias parroquia142=new Parroquias("142",48,"Alfredo Pacheco Miranda",1,1); parroquia142.save();
        Parroquias parroquia143=new Parroquias("143",49,"Santos Michelena",1,1); parroquia143.save();
        Parroquias parroquia144=new Parroquias("144",49,"Tiara",1,1); parroquia144.save();
        Parroquias parroquia145=new Parroquias("145",50,"Cagua",1,1); parroquia145.save();
        Parroquias parroquia146=new Parroquias("146",50,"Bella Vista",1,1); parroquia146.save();
        Parroquias parroquia147=new Parroquias("147",51,"Tovar",1,1); parroquia147.save();
        Parroquias parroquia148=new Parroquias("148",52,"Urdaneta",1,1); parroquia148.save();
        Parroquias parroquia149=new Parroquias("149",52,"Las Peñitas",1,1); parroquia149.save();
        Parroquias parroquia150=new Parroquias("150",52,"San Francisco de Cara",1,1); parroquia150.save();
        Parroquias parroquia151=new Parroquias("151",52,"Taguay",1,1); parroquia151.save();
        Parroquias parroquia152=new Parroquias("152",53,"Zamora",1,1); parroquia152.save();
        Parroquias parroquia153=new Parroquias("153",53,"Magdaleno",1,1); parroquia153.save();
        Parroquias parroquia154=new Parroquias("154",53,"San Francisco de Asís",1,1); parroquia154.save();
        Parroquias parroquia155=new Parroquias("155",53,"Valles de Tucutunemo",1,1); parroquia155.save();
        Parroquias parroquia156=new Parroquias("156",53,"Augusto Mijares",1,1); parroquia156.save();
        Parroquias parroquia157=new Parroquias("157",54,"Sabaneta",1,1); parroquia157.save();
        Parroquias parroquia158=new Parroquias("158",54,"Juan Antonio Rodríguez Domínguez",1,1); parroquia158.save();
        Parroquias parroquia159=new Parroquias("159",55,"El Cantón",1,1); parroquia159.save();
        Parroquias parroquia160=new Parroquias("160",55,"Santa Cruz de Guacas",1,1); parroquia160.save();
        Parroquias parroquia161=new Parroquias("161",55,"Puerto Vivas",1,1); parroquia161.save();
        Parroquias parroquia162=new Parroquias("162",56,"Ticoporo",1,1); parroquia162.save();
        Parroquias parroquia163=new Parroquias("163",56,"Nicolás Pulido",1,1); parroquia163.save();
        Parroquias parroquia164=new Parroquias("164",56,"Andrés Bello",1,1); parroquia164.save();
        Parroquias parroquia165=new Parroquias("165",57,"Arismendi",1,1); parroquia165.save();
        Parroquias parroquia166=new Parroquias("166",57,"Guadarrama",1,1); parroquia166.save();
        Parroquias parroquia167=new Parroquias("167",57,"La Unión",1,1); parroquia167.save();
        Parroquias parroquia168=new Parroquias("168",57,"San Antonio",1,1); parroquia168.save();
        Parroquias parroquia169=new Parroquias("169",58,"Barinas",1,1); parroquia169.save();
        Parroquias parroquia170=new Parroquias("170",58,"Alberto Arvelo Larriva",1,1); parroquia170.save();
        Parroquias parroquia171=new Parroquias("171",58,"San Silvestre",1,1); parroquia171.save();
        Parroquias parroquia172=new Parroquias("172",58,"Santa Inés",1,1); parroquia172.save();
        Parroquias parroquia173=new Parroquias("173",58,"Santa Lucía",1,1); parroquia173.save();
        Parroquias parroquia174=new Parroquias("174",58,"Torumos",1,1); parroquia174.save();
        Parroquias parroquia175=new Parroquias("175",58,"El Carmen",1,1); parroquia175.save();
        Parroquias parroquia176=new Parroquias("176",58,"Rómulo Betancourt",1,1); parroquia176.save();
        Parroquias parroquia177=new Parroquias("177",58,"Corazón de Jesús",1,1); parroquia177.save();
        Parroquias parroquia178=new Parroquias("178",58,"Ramón Ignacio Méndez",1,1); parroquia178.save();
        Parroquias parroquia179=new Parroquias("179",58,"Alto Barinas",1,1); parroquia179.save();
        Parroquias parroquia180=new Parroquias("180",58,"Manuel Palacio Fajardo",1,1); parroquia180.save();
        Parroquias parroquia181=new Parroquias("181",58,"Juan Antonio Rodríguez Domínguez",1,1); parroquia181.save();
        Parroquias parroquia182=new Parroquias("182",58,"Dominga Ortiz de Páez",1,1); parroquia182.save();
        Parroquias parroquia183=new Parroquias("183",59,"Barinitas",1,1); parroquia183.save();
        Parroquias parroquia184=new Parroquias("184",59,"Altamira de Cáceres",1,1); parroquia184.save();
        Parroquias parroquia185=new Parroquias("185",59,"Calderas",1,1); parroquia185.save();
        Parroquias parroquia186=new Parroquias("186",60,"Barrancas",1,1); parroquia186.save();
        Parroquias parroquia187=new Parroquias("187",60,"El Socorro",1,1); parroquia187.save();
        Parroquias parroquia188=new Parroquias("188",60,"Mazparrito",1,1); parroquia188.save();
        Parroquias parroquia189=new Parroquias("189",61,"Santa Bárbara",1,1); parroquia189.save();
        Parroquias parroquia190=new Parroquias("190",61,"Pedro Briceño Méndez",1,1); parroquia190.save();
        Parroquias parroquia191=new Parroquias("191",61,"Ramón Ignacio Méndez",1,1); parroquia191.save();
        Parroquias parroquia192=new Parroquias("192",61,"José Ignacio del Pumar",1,1); parroquia192.save();
        Parroquias parroquia193=new Parroquias("193",62,"Obispos",1,1); parroquia193.save();
        Parroquias parroquia194=new Parroquias("194",62,"Guasimitos",1,1); parroquia194.save();
        Parroquias parroquia195=new Parroquias("195",62,"El Real",1,1); parroquia195.save();
        Parroquias parroquia196=new Parroquias("196",62,"La Luz",1,1); parroquia196.save();
        Parroquias parroquia197=new Parroquias("197",63,"Ciudad Bolívia",1,1); parroquia197.save();
        Parroquias parroquia198=new Parroquias("198",63,"José Ignacio Briceño",1,1); parroquia198.save();
        Parroquias parroquia199=new Parroquias("199",63,"José Félix Ribas",1,1); parroquia199.save();
        Parroquias parroquia200=new Parroquias("200",63,"Páez",1,1); parroquia200.save();
        Parroquias parroquia201=new Parroquias("201",64,"Libertad",1,1); parroquia201.save();
        Parroquias parroquia202=new Parroquias("202",64,"Dolores",1,1); parroquia202.save();
        Parroquias parroquia203=new Parroquias("203",64,"Santa Rosa",1,1); parroquia203.save();
        Parroquias parroquia204=new Parroquias("204",64,"Palacio Fajardo",1,1); parroquia204.save();
        Parroquias parroquia205=new Parroquias("205",65,"Ciudad de Nutrias",1,1); parroquia205.save();
        Parroquias parroquia206=new Parroquias("206",65,"El Regalo",1,1); parroquia206.save();
        Parroquias parroquia207=new Parroquias("207",65,"Puerto Nutrias",1,1); parroquia207.save();
        Parroquias parroquia208=new Parroquias("208",65,"Santa Catalina",1,1); parroquia208.save();
        Parroquias parroquia209=new Parroquias("209",66,"Cachamay",1,1); parroquia209.save();
        Parroquias parroquia210=new Parroquias("210",66,"Chirica",1,1); parroquia210.save();
        Parroquias parroquia211=new Parroquias("211",66,"Dalla Costa",1,1); parroquia211.save();
        Parroquias parroquia212=new Parroquias("212",66,"Once de Abril",1,1); parroquia212.save();
        Parroquias parroquia213=new Parroquias("213",66,"Simón Bolívar",1,1); parroquia213.save();
        Parroquias parroquia214=new Parroquias("214",66,"Unare",1,1); parroquia214.save();
        Parroquias parroquia215=new Parroquias("215",66,"Universidad",1,1); parroquia215.save();
        Parroquias parroquia216=new Parroquias("216",66,"Vista al Sol",1,1); parroquia216.save();
        Parroquias parroquia217=new Parroquias("217",66,"Pozo Verde",1,1); parroquia217.save();
        Parroquias parroquia218=new Parroquias("218",66,"Yocoima",1,1); parroquia218.save();
        Parroquias parroquia219=new Parroquias("219",66,"5 de Julio",1,1); parroquia219.save();
        Parroquias parroquia220=new Parroquias("220",67,"Cedeño",1,1); parroquia220.save();
        Parroquias parroquia221=new Parroquias("221",67,"Altagracia",1,1); parroquia221.save();
        Parroquias parroquia222=new Parroquias("222",67,"Ascensión Farreras",1,1); parroquia222.save();
        Parroquias parroquia223=new Parroquias("223",67,"Guaniamo",1,1); parroquia223.save();
        Parroquias parroquia224=new Parroquias("224",67,"La Urbana",1,1); parroquia224.save();
        Parroquias parroquia225=new Parroquias("225",67,"Pijiguaos",1,1); parroquia225.save();
        Parroquias parroquia226=new Parroquias("226",68,"El Callao",1,1); parroquia226.save();
        Parroquias parroquia227=new Parroquias("227",69,"Gran Sabana",1,1); parroquia227.save();
        Parroquias parroquia228=new Parroquias("228",69,"Ikabarú",1,1); parroquia228.save();
        Parroquias parroquia229=new Parroquias("229",70,"Catedral",1,1); parroquia229.save();
        Parroquias parroquia230=new Parroquias("230",70,"Zea",1,1); parroquia230.save();
        Parroquias parroquia231=new Parroquias("231",70,"Orinoco",1,1); parroquia231.save();
        Parroquias parroquia232=new Parroquias("232",70,"José Antonio Páez",1,1); parroquia232.save();
        Parroquias parroquia233=new Parroquias("233",70,"Marhuanta",1,1); parroquia233.save();
        Parroquias parroquia234=new Parroquias("234",70,"Agua Salada",1,1); parroquia234.save();
        Parroquias parroquia235=new Parroquias("235",70,"Vista Hermosa",1,1); parroquia235.save();
        Parroquias parroquia236=new Parroquias("236",70,"La Sabanita",1,1); parroquia236.save();
        Parroquias parroquia237=new Parroquias("237",70,"Panapana",1,1); parroquia237.save();
        Parroquias parroquia238=new Parroquias("238",71,"Andrés Eloy Blanco",1,1); parroquia238.save();
        Parroquias parroquia239=new Parroquias("239",71,"Pedro Cova",1,1); parroquia239.save();
        Parroquias parroquia240=new Parroquias("240",72,"Raúl Leoni",1,1); parroquia240.save();
        Parroquias parroquia241=new Parroquias("241",72,"Barceloneta",1,1); parroquia241.save();
        Parroquias parroquia242=new Parroquias("242",72,"Santa Bárbara",1,1); parroquia242.save();
        Parroquias parroquia243=new Parroquias("243",72,"San Francisco",1,1); parroquia243.save();
        Parroquias parroquia244=new Parroquias("244",73,"Roscio",1,1); parroquia244.save();
        Parroquias parroquia245=new Parroquias("245",73,"Salóm",1,1); parroquia245.save();
        Parroquias parroquia246=new Parroquias("246",74,"Sifontes",1,1); parroquia246.save();
        Parroquias parroquia247=new Parroquias("247",74,"Dalla Costa",1,1); parroquia247.save();
        Parroquias parroquia248=new Parroquias("248",74,"San Isidro",1,1); parroquia248.save();
        Parroquias parroquia249=new Parroquias("249",75,"Sucre",1,1); parroquia249.save();
        Parroquias parroquia250=new Parroquias("250",75,"Aripao",1,1); parroquia250.save();
        Parroquias parroquia251=new Parroquias("251",75,"Guarataro",1,1); parroquia251.save();
        Parroquias parroquia252=new Parroquias("252",75,"Las Majadas",1,1); parroquia252.save();
        Parroquias parroquia253=new Parroquias("253",75,"Moitaco",1,1); parroquia253.save();
        Parroquias parroquia254=new Parroquias("254",76,"Padre Pedro Chien",1,1); parroquia254.save();
        Parroquias parroquia255=new Parroquias("255",76,"Río Grande",1,1); parroquia255.save();
        Parroquias parroquia256=new Parroquias("256",77,"Bejuma",1,1); parroquia256.save();
        Parroquias parroquia257=new Parroquias("257",77,"Canoabo",1,1); parroquia257.save();
        Parroquias parroquia258=new Parroquias("258",77,"Simón Bolívar",1,1); parroquia258.save();
        Parroquias parroquia259=new Parroquias("259",78,"Güigüe",1,1); parroquia259.save();
        Parroquias parroquia260=new Parroquias("260",78,"Carabobo",1,1); parroquia260.save();
        Parroquias parroquia261=new Parroquias("261",78,"Tacarigua",1,1); parroquia261.save();
        Parroquias parroquia262=new Parroquias("262",79,"Mariara",1,1); parroquia262.save();
        Parroquias parroquia263=new Parroquias("263",79,"Aguas Calientes",1,1); parroquia263.save();
        Parroquias parroquia264=new Parroquias("264",80,"Ciudad Alianza",1,1); parroquia264.save();
        Parroquias parroquia265=new Parroquias("265",80,"Guacara",1,1); parroquia265.save();
        Parroquias parroquia266=new Parroquias("266",80,"Yagua",1,1); parroquia266.save();
        Parroquias parroquia267=new Parroquias("267",81,"Morón",1,1); parroquia267.save();
        Parroquias parroquia268=new Parroquias("268",81,"Yagua",1,1); parroquia268.save();
        Parroquias parroquia269=new Parroquias("269",82,"Tocuyito",1,1); parroquia269.save();
        Parroquias parroquia270=new Parroquias("270",82,"Independencia",1,1); parroquia270.save();
        Parroquias parroquia271=new Parroquias("271",83,"Los Guayos",1,1); parroquia271.save();
        Parroquias parroquia272=new Parroquias("272",84,"Miranda",1,1); parroquia272.save();
        Parroquias parroquia273=new Parroquias("273",85,"Montalbán",1,1); parroquia273.save();
        Parroquias parroquia274=new Parroquias("274",86,"Naguanagua",1,1); parroquia274.save();
        Parroquias parroquia275=new Parroquias("275",87,"Bartolomé Salóm",1,1); parroquia275.save();
        Parroquias parroquia276=new Parroquias("276",87,"Democracia",1,1); parroquia276.save();
        Parroquias parroquia277=new Parroquias("277",87,"Fraternidad",1,1); parroquia277.save();
        Parroquias parroquia278=new Parroquias("278",87,"Goaigoaza",1,1); parroquia278.save();
        Parroquias parroquia279=new Parroquias("279",87,"Juan José Flores",1,1); parroquia279.save();
        Parroquias parroquia280=new Parroquias("280",87,"Unión",1,1); parroquia280.save();
        Parroquias parroquia281=new Parroquias("281",87,"Borburata",1,1); parroquia281.save();
        Parroquias parroquia282=new Parroquias("282",87,"Patanemo",1,1); parroquia282.save();
        Parroquias parroquia283=new Parroquias("283",88,"San Diego",1,1); parroquia283.save();
        Parroquias parroquia284=new Parroquias("284",89,"San Joaquín",1,1); parroquia284.save();
        Parroquias parroquia285=new Parroquias("285",90,"Candelaria",1,1); parroquia285.save();
        Parroquias parroquia286=new Parroquias("286",90,"Catedral",1,1); parroquia286.save();
        Parroquias parroquia287=new Parroquias("287",90,"El Socorro",1,1); parroquia287.save();
        Parroquias parroquia288=new Parroquias("288",90,"Miguel Peña",1,1); parroquia288.save();
        Parroquias parroquia289=new Parroquias("289",90,"Rafael Urdaneta",1,1); parroquia289.save();
        Parroquias parroquia290=new Parroquias("290",90,"San Blas",1,1); parroquia290.save();
        Parroquias parroquia291=new Parroquias("291",90,"San José",1,1); parroquia291.save();
        Parroquias parroquia292=new Parroquias("292",90,"Santa Rosa",1,1); parroquia292.save();
        Parroquias parroquia293=new Parroquias("293",90,"Negro Primero",1,1); parroquia293.save();
        Parroquias parroquia294=new Parroquias("294",91,"Cojedes",1,1); parroquia294.save();
        Parroquias parroquia295=new Parroquias("295",91,"Juan de Mata Suárez",1,1); parroquia295.save();
        Parroquias parroquia296=new Parroquias("296",92,"Tinaquillo",1,1); parroquia296.save();
        Parroquias parroquia297=new Parroquias("297",93,"El Baúl",1,1); parroquia297.save();
        Parroquias parroquia298=new Parroquias("298",93,"Sucre",1,1); parroquia298.save();
        Parroquias parroquia299=new Parroquias("299",94,"La Aguadita",1,1); parroquia299.save();
        Parroquias parroquia300=new Parroquias("300",94,"Macapo",1,1); parroquia300.save();
        Parroquias parroquia301=new Parroquias("301",95,"El Pao",1,1); parroquia301.save();
        Parroquias parroquia302=new Parroquias("302",96,"El Amparo",1,1); parroquia302.save();
        Parroquias parroquia303=new Parroquias("303",96,"Libertad de Cojedes",1,1); parroquia303.save();
        Parroquias parroquia304=new Parroquias("304",97,"Rómulo Gallegos",1,1); parroquia304.save();
        Parroquias parroquia305=new Parroquias("305",98,"San Carlos de Austria",1,1); parroquia305.save();
        Parroquias parroquia306=new Parroquias("306",98,"Juan Ángel Bravo",1,1); parroquia306.save();
        Parroquias parroquia307=new Parroquias("307",98,"Manuel Manrique",1,1); parroquia307.save();
        Parroquias parroquia308=new Parroquias("308",99,"General en Jefe José Laurencio Silva",1,1); parroquia308.save();
        Parroquias parroquia309=new Parroquias("309",100,"Curiapo",1,1); parroquia309.save();
        Parroquias parroquia310=new Parroquias("310",100,"Almirante Luis Brión",1,1); parroquia310.save();
        Parroquias parroquia311=new Parroquias("311",100,"Francisco Aniceto Lugo",1,1); parroquia311.save();
        Parroquias parroquia312=new Parroquias("312",100,"Manuel Renaud",1,1); parroquia312.save();
        Parroquias parroquia313=new Parroquias("313",100,"Padre Barral",1,1); parroquia313.save();
        Parroquias parroquia314=new Parroquias("314",100,"Santos de Abelgas",1,1); parroquia314.save();
        Parroquias parroquia315=new Parroquias("315",101,"Imataca",1,1); parroquia315.save();
        Parroquias parroquia316=new Parroquias("316",101,"Cinco de Julio",1,1); parroquia316.save();
        Parroquias parroquia317=new Parroquias("317",101,"Juan Bautista Arismendi",1,1); parroquia317.save();
        Parroquias parroquia318=new Parroquias("318",101,"Manuel Piar",1,1); parroquia318.save();
        Parroquias parroquia319=new Parroquias("319",101,"Rómulo Gallegos",1,1); parroquia319.save();
        Parroquias parroquia320=new Parroquias("320",102,"Pedernales",1,1); parroquia320.save();
        Parroquias parroquia321=new Parroquias("321",102,"Luis Beltrán Prieto Figueroa",1,1); parroquia321.save();
        Parroquias parroquia322=new Parroquias("322",103,"San José (Delta Amacuro)",1,1); parroquia322.save();
        Parroquias parroquia323=new Parroquias("323",103,"José Vidal Marcano",1,1); parroquia323.save();
        Parroquias parroquia324=new Parroquias("324",103,"Juan Millán",1,1); parroquia324.save();
        Parroquias parroquia325=new Parroquias("325",103,"Leonardo Ruíz Pineda",1,1); parroquia325.save();
        Parroquias parroquia326=new Parroquias("326",103,"Mariscal Antonio José de Sucre",1,1); parroquia326.save();
        Parroquias parroquia327=new Parroquias("327",103,"Monseñor Argimiro García",1,1); parroquia327.save();
        Parroquias parroquia328=new Parroquias("328",103,"San Rafael (Delta Amacuro)",1,1); parroquia328.save();
        Parroquias parroquia329=new Parroquias("329",103,"Virgen del Valle",1,1); parroquia329.save();
        Parroquias parroquia330=new Parroquias("330",10,"Clarines",1,1); parroquia330.save();
        Parroquias parroquia331=new Parroquias("331",10,"Guanape",1,1); parroquia331.save();
        Parroquias parroquia332=new Parroquias("332",10,"Sabana de Uchire",1,1); parroquia332.save();
        Parroquias parroquia333=new Parroquias("333",104,"Capadare",1,1); parroquia333.save();
        Parroquias parroquia334=new Parroquias("334",104,"La Pastora",1,1); parroquia334.save();
        Parroquias parroquia335=new Parroquias("335",104,"Libertador",1,1); parroquia335.save();
        Parroquias parroquia336=new Parroquias("336",104,"San Juan de los Cayos",1,1); parroquia336.save();
        Parroquias parroquia337=new Parroquias("337",105,"Aracua",1,1); parroquia337.save();
        Parroquias parroquia338=new Parroquias("338",105,"La Peña",1,1); parroquia338.save();
        Parroquias parroquia339=new Parroquias("339",105,"San Luis",1,1); parroquia339.save();
        Parroquias parroquia340=new Parroquias("340",106,"Bariro",1,1); parroquia340.save();
        Parroquias parroquia341=new Parroquias("341",106,"Borojó",1,1); parroquia341.save();
        Parroquias parroquia342=new Parroquias("342",106,"Capatárida",1,1); parroquia342.save();
        Parroquias parroquia343=new Parroquias("343",106,"Guajiro",1,1); parroquia343.save();
        Parroquias parroquia344=new Parroquias("344",106,"Seque",1,1); parroquia344.save();
        Parroquias parroquia345=new Parroquias("345",106,"Zazárida",1,1); parroquia345.save();
        Parroquias parroquia346=new Parroquias("346",106,"Valle de Eroa",1,1); parroquia346.save();
        Parroquias parroquia347=new Parroquias("347",107,"Cacique Manaure",1,1); parroquia347.save();
        Parroquias parroquia348=new Parroquias("348",108,"Norte",1,1); parroquia348.save();
        Parroquias parroquia349=new Parroquias("349",108,"Carirubana",1,1); parroquia349.save();
        Parroquias parroquia350=new Parroquias("350",108,"Santa Ana",1,1); parroquia350.save();
        Parroquias parroquia351=new Parroquias("351",108,"Urbana Punta Cardón",1,1); parroquia351.save();
        Parroquias parroquia352=new Parroquias("352",109,"La Vela de Coro",1,1); parroquia352.save();
        Parroquias parroquia353=new Parroquias("353",109,"Acurigua",1,1); parroquia353.save();
        Parroquias parroquia354=new Parroquias("354",109,"Guaibacoa",1,1); parroquia354.save();
        Parroquias parroquia355=new Parroquias("355",109,"Las Calderas",1,1); parroquia355.save();
        Parroquias parroquia356=new Parroquias("356",109,"Macoruca",1,1); parroquia356.save();
        Parroquias parroquia357=new Parroquias("357",110,"Dabajuro",1,1); parroquia357.save();
        Parroquias parroquia358=new Parroquias("358",111,"Agua Clara",1,1); parroquia358.save();
        Parroquias parroquia359=new Parroquias("359",111,"Avaria",1,1); parroquia359.save();
        Parroquias parroquia360=new Parroquias("360",111,"Pedregal",1,1); parroquia360.save();
        Parroquias parroquia361=new Parroquias("361",111,"Piedra Grande",1,1); parroquia361.save();
        Parroquias parroquia362=new Parroquias("362",111,"Purureche",1,1); parroquia362.save();
        Parroquias parroquia363=new Parroquias("363",112,"Adaure",1,1); parroquia363.save();
        Parroquias parroquia364=new Parroquias("364",112,"Adícora",1,1); parroquia364.save();
        Parroquias parroquia365=new Parroquias("365",112,"Baraived",1,1); parroquia365.save();
        Parroquias parroquia366=new Parroquias("366",112,"Buena Vista",1,1); parroquia366.save();
        Parroquias parroquia367=new Parroquias("367",112,"Jadacaquiva",1,1); parroquia367.save();
        Parroquias parroquia368=new Parroquias("368",112,"El Vínculo",1,1); parroquia368.save();
        Parroquias parroquia369=new Parroquias("369",112,"El Hato",1,1); parroquia369.save();
        Parroquias parroquia370=new Parroquias("370",112,"Moruy",1,1); parroquia370.save();
        Parroquias parroquia371=new Parroquias("371",112,"Pueblo Nuevo",1,1); parroquia371.save();
        Parroquias parroquia372=new Parroquias("372",113,"Agua Larga",1,1); parroquia372.save();
        Parroquias parroquia373=new Parroquias("373",113,"El Paují",1,1); parroquia373.save();
        Parroquias parroquia374=new Parroquias("374",113,"Independencia",1,1); parroquia374.save();
        Parroquias parroquia375=new Parroquias("375",113,"Mapararí",1,1); parroquia375.save();
        Parroquias parroquia376=new Parroquias("376",114,"Agua Linda",1,1); parroquia376.save();
        Parroquias parroquia377=new Parroquias("377",114,"Araurima",1,1); parroquia377.save();
        Parroquias parroquia378=new Parroquias("378",114,"Jacura",1,1); parroquia378.save();
        Parroquias parroquia379=new Parroquias("379",115,"Tucacas",1,1); parroquia379.save();
        Parroquias parroquia380=new Parroquias("380",115,"Boca de Aroa",1,1); parroquia380.save();
        Parroquias parroquia381=new Parroquias("381",116,"Los Taques",1,1); parroquia381.save();
        Parroquias parroquia382=new Parroquias("382",116,"Judibana",1,1); parroquia382.save();
        Parroquias parroquia383=new Parroquias("383",117,"Mene de Mauroa",1,1); parroquia383.save();
        Parroquias parroquia384=new Parroquias("384",117,"San Félix",1,1); parroquia384.save();
        Parroquias parroquia385=new Parroquias("385",117,"Casigua",1,1); parroquia385.save();
        Parroquias parroquia386=new Parroquias("386",118,"Guzmán Guillermo",1,1); parroquia386.save();
        Parroquias parroquia387=new Parroquias("387",118,"Mitare",1,1); parroquia387.save();
        Parroquias parroquia388=new Parroquias("388",118,"Río Seco",1,1); parroquia388.save();
        Parroquias parroquia389=new Parroquias("389",118,"Sabaneta",1,1); parroquia389.save();
        Parroquias parroquia390=new Parroquias("390",118,"San Antonio",1,1); parroquia390.save();
        Parroquias parroquia391=new Parroquias("391",118,"San Gabriel",1,1); parroquia391.save();
        Parroquias parroquia392=new Parroquias("392",118,"Santa Ana",1,1); parroquia392.save();
        Parroquias parroquia393=new Parroquias("393",119,"Boca del Tocuyo",1,1); parroquia393.save();
        Parroquias parroquia394=new Parroquias("394",119,"Chichiriviche",1,1); parroquia394.save();
        Parroquias parroquia395=new Parroquias("395",119,"Tocuyo de la Costa",1,1); parroquia395.save();
        Parroquias parroquia396=new Parroquias("396",120,"Palmasola",1,1); parroquia396.save();
        Parroquias parroquia397=new Parroquias("397",121,"Cabure",1,1); parroquia397.save();
        Parroquias parroquia398=new Parroquias("398",121,"Colina",1,1); parroquia398.save();
        Parroquias parroquia399=new Parroquias("399",121,"Curimagua",1,1); parroquia399.save();
        Parroquias parroquia400=new Parroquias("400",122,"San José de la Costa",1,1); parroquia400.save();
        Parroquias parroquia401=new Parroquias("401",122,"Píritu",1,1); parroquia401.save();
        Parroquias parroquia402=new Parroquias("402",123,"San Francisco",1,1); parroquia402.save();
        Parroquias parroquia403=new Parroquias("403",124,"Sucre",1,1); parroquia403.save();
        Parroquias parroquia404=new Parroquias("404",124,"Pecaya",1,1); parroquia404.save();
        Parroquias parroquia405=new Parroquias("405",125,"Tocópero",1,1); parroquia405.save();
        Parroquias parroquia406=new Parroquias("406",126,"El Charal",1,1); parroquia406.save();
        Parroquias parroquia407=new Parroquias("407",126,"Las Vegas del Tuy",1,1); parroquia407.save();
        Parroquias parroquia408=new Parroquias("408",126,"Santa Cruz de Bucaral",1,1); parroquia408.save();
        Parroquias parroquia409=new Parroquias("409",127,"Bruzual",1,1); parroquia409.save();
        Parroquias parroquia410=new Parroquias("410",127,"Urumaco",1,1); parroquia410.save();
        Parroquias parroquia411=new Parroquias("411",128,"Puerto Cumarebo",1,1); parroquia411.save();
        Parroquias parroquia412=new Parroquias("412",128,"La Ciénaga",1,1); parroquia412.save();
        Parroquias parroquia413=new Parroquias("413",128,"La Soledad",1,1); parroquia413.save();
        Parroquias parroquia414=new Parroquias("414",128,"Pueblo Cumarebo",1,1); parroquia414.save();
        Parroquias parroquia415=new Parroquias("415",128,"Zazárida",1,1); parroquia415.save();
        Parroquias parroquia416=new Parroquias("416",113,"Churuguara",1,1); parroquia416.save();
        Parroquias parroquia417=new Parroquias("417",129,"Camaguán",1,1); parroquia417.save();
        Parroquias parroquia418=new Parroquias("418",129,"Puerto Miranda",1,1); parroquia418.save();
        Parroquias parroquia419=new Parroquias("419",129,"Uverito",1,1); parroquia419.save();
        Parroquias parroquia420=new Parroquias("420",130,"Chaguaramas",1,1); parroquia420.save();
        Parroquias parroquia421=new Parroquias("421",131,"El Socorro",1,1); parroquia421.save();
        Parroquias parroquia422=new Parroquias("422",132,"Tucupido",1,1); parroquia422.save();
        Parroquias parroquia423=new Parroquias("423",132,"San Rafael de Laya",1,1); parroquia423.save();
        Parroquias parroquia424=new Parroquias("424",133,"Altagracia de Orituco",1,1); parroquia424.save();
        Parroquias parroquia425=new Parroquias("425",133,"San Rafael de Orituco",1,1); parroquia425.save();
        Parroquias parroquia426=new Parroquias("426",133,"San Francisco Javier de Lezama",1,1); parroquia426.save();
        Parroquias parroquia427=new Parroquias("427",133,"Paso Real de Macaira",1,1); parroquia427.save();
        Parroquias parroquia428=new Parroquias("428",133,"Carlos Soublette",1,1); parroquia428.save();
        Parroquias parroquia429=new Parroquias("429",133,"San Francisco de Macaira",1,1); parroquia429.save();
        Parroquias parroquia430=new Parroquias("430",133,"Libertad de Orituco",1,1); parroquia430.save();
        Parroquias parroquia431=new Parroquias("431",134,"Cantaclaro",1,1); parroquia431.save();
        Parroquias parroquia432=new Parroquias("432",134,"San Juan de los Morros",1,1); parroquia432.save();
        Parroquias parroquia433=new Parroquias("433",134,"Parapara",1,1); parroquia433.save();
        Parroquias parroquia434=new Parroquias("434",135,"El Sombrero",1,1); parroquia434.save();
        Parroquias parroquia435=new Parroquias("435",135,"Sosa",1,1); parroquia435.save();
        Parroquias parroquia436=new Parroquias("436",136,"Las Mercedes",1,1); parroquia436.save();
        Parroquias parroquia437=new Parroquias("437",136,"Cabruta",1,1); parroquia437.save();
        Parroquias parroquia438=new Parroquias("438",136,"Santa Rita de Manapire",1,1); parroquia438.save();
        Parroquias parroquia439=new Parroquias("439",137,"Valle de la Pascua",1,1); parroquia439.save();
        Parroquias parroquia440=new Parroquias("440",137,"Espino",1,1); parroquia440.save();
        Parroquias parroquia441=new Parroquias("441",138,"San José de Unare",1,1); parroquia441.save();
        Parroquias parroquia442=new Parroquias("442",138,"Zaraza",1,1); parroquia442.save();
        Parroquias parroquia443=new Parroquias("443",139,"San José de Tiznados",1,1); parroquia443.save();
        Parroquias parroquia444=new Parroquias("444",139,"San Francisco de Tiznados",1,1); parroquia444.save();
        Parroquias parroquia445=new Parroquias("445",139,"San Lorenzo de Tiznados",1,1); parroquia445.save();
        Parroquias parroquia446=new Parroquias("446",139,"Ortiz",1,1); parroquia446.save();
        Parroquias parroquia447=new Parroquias("447",140,"Guayabal",1,1); parroquia447.save();
        Parroquias parroquia448=new Parroquias("448",140,"Cazorla",1,1); parroquia448.save();
        Parroquias parroquia449=new Parroquias("449",141,"San José de Guaribe",1,1); parroquia449.save();
        Parroquias parroquia450=new Parroquias("450",141,"Uveral",1,1); parroquia450.save();
        Parroquias parroquia451=new Parroquias("451",142,"Santa María de Ipire",1,1); parroquia451.save();
        Parroquias parroquia452=new Parroquias("452",142,"Altamira",1,1); parroquia452.save();
        Parroquias parroquia453=new Parroquias("453",143,"El Calvario",1,1); parroquia453.save();
        Parroquias parroquia454=new Parroquias("454",143,"El Rastro",1,1); parroquia454.save();
        Parroquias parroquia455=new Parroquias("455",143,"Guardatinajas",1,1); parroquia455.save();
        Parroquias parroquia456=new Parroquias("456",143,"Capital Urbana Calabozo",1,1); parroquia456.save();
        Parroquias parroquia457=new Parroquias("457",144,"Quebrada Honda de Guache",1,1); parroquia457.save();
        Parroquias parroquia458=new Parroquias("458",144,"Pío Tamayo",1,1); parroquia458.save();
        Parroquias parroquia459=new Parroquias("459",144,"Yacambú",1,1); parroquia459.save();
        Parroquias parroquia460=new Parroquias("460",145,"Fréitez",1,1); parroquia460.save();
        Parroquias parroquia461=new Parroquias("461",145,"José María Blanco",1,1); parroquia461.save();
        Parroquias parroquia462=new Parroquias("462",146,"Catedral",1,1); parroquia462.save();
        Parroquias parroquia463=new Parroquias("463",146,"Concepción",1,1); parroquia463.save();
        Parroquias parroquia464=new Parroquias("464",146,"El Cují",1,1); parroquia464.save();
        Parroquias parroquia465=new Parroquias("465",146,"Juan de Villegas",1,1); parroquia465.save();
        Parroquias parroquia466=new Parroquias("466",146,"Santa Rosa",1,1); parroquia466.save();
        Parroquias parroquia467=new Parroquias("467",146,"Tamaca",1,1); parroquia467.save();
        Parroquias parroquia468=new Parroquias("468",146,"Unión",1,1); parroquia468.save();
        Parroquias parroquia469=new Parroquias("469",146,"Aguedo Felipe Alvarado",1,1); parroquia469.save();
        Parroquias parroquia470=new Parroquias("470",146,"Buena Vista",1,1); parroquia470.save();
        Parroquias parroquia471=new Parroquias("471",146,"Juárez",1,1); parroquia471.save();
        Parroquias parroquia472=new Parroquias("472",147,"Juan Bautista Rodríguez",1,1); parroquia472.save();
        Parroquias parroquia473=new Parroquias("473",147,"Cuara",1,1); parroquia473.save();
        Parroquias parroquia474=new Parroquias("474",147,"Diego de Lozada",1,1); parroquia474.save();
        Parroquias parroquia475=new Parroquias("475",147,"Paraíso de San José",1,1); parroquia475.save();
        Parroquias parroquia476=new Parroquias("476",147,"San Miguel",1,1); parroquia476.save();
        Parroquias parroquia477=new Parroquias("477",147,"Tintorero",1,1); parroquia477.save();
        Parroquias parroquia478=new Parroquias("478",147,"José Bernardo Dorante",1,1); parroquia478.save();
        Parroquias parroquia479=new Parroquias("479",147,"Coronel Mariano Peraza ",1,1); parroquia479.save();
        Parroquias parroquia480=new Parroquias("480",148,"Bolívar",1,1); parroquia480.save();
        Parroquias parroquia481=new Parroquias("481",148,"Anzoátegui",1,1); parroquia481.save();
        Parroquias parroquia482=new Parroquias("482",148,"Guarico",1,1); parroquia482.save();
        Parroquias parroquia483=new Parroquias("483",148,"Hilario Luna y Luna",1,1); parroquia483.save();
        Parroquias parroquia484=new Parroquias("484",148,"Humocaro Alto",1,1); parroquia484.save();
        Parroquias parroquia485=new Parroquias("485",148,"Humocaro Bajo",1,1); parroquia485.save();
        Parroquias parroquia486=new Parroquias("486",148,"La Candelaria",1,1); parroquia486.save();
        Parroquias parroquia487=new Parroquias("487",148,"Morán",1,1); parroquia487.save();
        Parroquias parroquia488=new Parroquias("488",149,"Cabudare",1,1); parroquia488.save();
        Parroquias parroquia489=new Parroquias("489",149,"José Gregorio Bastidas",1,1); parroquia489.save();
        Parroquias parroquia490=new Parroquias("490",149,"Agua Viva",1,1); parroquia490.save();
        Parroquias parroquia491=new Parroquias("491",150,"Sarare",1,1); parroquia491.save();
        Parroquias parroquia492=new Parroquias("492",150,"Buría",1,1); parroquia492.save();
        Parroquias parroquia493=new Parroquias("493",150,"Gustavo Vegas León",1,1); parroquia493.save();
        Parroquias parroquia494=new Parroquias("494",151,"Trinidad Samuel",1,1); parroquia494.save();
        Parroquias parroquia495=new Parroquias("495",151,"Antonio Díaz",1,1); parroquia495.save();
        Parroquias parroquia496=new Parroquias("496",151,"Camacaro",1,1); parroquia496.save();
        Parroquias parroquia497=new Parroquias("497",151,"Castañeda",1,1); parroquia497.save();
        Parroquias parroquia498=new Parroquias("498",151,"Cecilio Zubillaga",1,1); parroquia498.save();
        Parroquias parroquia499=new Parroquias("499",151,"Chiquinquirá",1,1); parroquia499.save();
        Parroquias parroquia500=new Parroquias("500",151,"El Blanco",1,1); parroquia500.save();
        Parroquias parroquia501=new Parroquias("501",151,"Espinoza de los Monteros",1,1); parroquia501.save();
        Parroquias parroquia502=new Parroquias("502",151,"Lara",1,1); parroquia502.save();
        Parroquias parroquia503=new Parroquias("503",151,"Las Mercedes",1,1); parroquia503.save();
        Parroquias parroquia504=new Parroquias("504",151,"Manuel Morillo",1,1); parroquia504.save();
        Parroquias parroquia505=new Parroquias("505",151,"Montaña Verde",1,1); parroquia505.save();
        Parroquias parroquia506=new Parroquias("506",151,"Montes de Oca",1,1); parroquia506.save();
        Parroquias parroquia507=new Parroquias("507",151,"Torres",1,1); parroquia507.save();
        Parroquias parroquia508=new Parroquias("508",151,"Heriberto Arroyo",1,1); parroquia508.save();
        Parroquias parroquia509=new Parroquias("509",151,"Reyes Vargas",1,1); parroquia509.save();
        Parroquias parroquia510=new Parroquias("510",151,"Altagracia",1,1); parroquia510.save();
        Parroquias parroquia511=new Parroquias("511",152,"Siquisique",1,1); parroquia511.save();
        Parroquias parroquia512=new Parroquias("512",152,"Moroturo",1,1); parroquia512.save();
        Parroquias parroquia513=new Parroquias("513",152,"San Miguel",1,1); parroquia513.save();
        Parroquias parroquia514=new Parroquias("514",152,"Xaguas",1,1); parroquia514.save();
        Parroquias parroquia515=new Parroquias("515",179,"Presidente Betancourt",1,1); parroquia515.save();
        Parroquias parroquia516=new Parroquias("516",179,"Presidente Páez",1,1); parroquia516.save();
        Parroquias parroquia517=new Parroquias("517",179,"Presidente Rómulo Gallegos",1,1); parroquia517.save();
        Parroquias parroquia518=new Parroquias("518",179,"Gabriel Picón González",1,1); parroquia518.save();
        Parroquias parroquia519=new Parroquias("519",179,"Héctor Amable Mora",1,1); parroquia519.save();
        Parroquias parroquia520=new Parroquias("520",179,"José Nucete Sardi",1,1); parroquia520.save();
        Parroquias parroquia521=new Parroquias("521",179,"Pulido Méndez",1,1); parroquia521.save();
        Parroquias parroquia522=new Parroquias("522",180,"La Azulita",1,1); parroquia522.save();
        Parroquias parroquia523=new Parroquias("523",181,"Santa Cruz de Mora",1,1); parroquia523.save();
        Parroquias parroquia524=new Parroquias("524",181,"Mesa Bolívar",1,1); parroquia524.save();
        Parroquias parroquia525=new Parroquias("525",181,"Mesa de Las Palmas",1,1); parroquia525.save();
        Parroquias parroquia526=new Parroquias("526",182,"Aricagua",1,1); parroquia526.save();
        Parroquias parroquia527=new Parroquias("527",182,"San Antonio",1,1); parroquia527.save();
        Parroquias parroquia528=new Parroquias("528",183,"Canagua",1,1); parroquia528.save();
        Parroquias parroquia529=new Parroquias("529",183,"Capurí",1,1); parroquia529.save();
        Parroquias parroquia530=new Parroquias("530",183,"Chacantá",1,1); parroquia530.save();
        Parroquias parroquia531=new Parroquias("531",183,"El Molino",1,1); parroquia531.save();
        Parroquias parroquia532=new Parroquias("532",183,"Guaimaral",1,1); parroquia532.save();
        Parroquias parroquia533=new Parroquias("533",183,"Mucutuy",1,1); parroquia533.save();
        Parroquias parroquia534=new Parroquias("534",183,"Mucuchachí",1,1); parroquia534.save();
        Parroquias parroquia535=new Parroquias("535",184,"Fernández Peña",1,1); parroquia535.save();
        Parroquias parroquia536=new Parroquias("536",184,"Matriz",1,1); parroquia536.save();
        Parroquias parroquia537=new Parroquias("537",184,"Montalbán",1,1); parroquia537.save();
        Parroquias parroquia538=new Parroquias("538",184,"Acequias",1,1); parroquia538.save();
        Parroquias parroquia539=new Parroquias("539",184,"Jají",1,1); parroquia539.save();
        Parroquias parroquia540=new Parroquias("540",184,"La Mesa",1,1); parroquia540.save();
        Parroquias parroquia541=new Parroquias("541",184,"San José del Sur",1,1); parroquia541.save();
        Parroquias parroquia542=new Parroquias("542",185,"Tucaní",1,1); parroquia542.save();
        Parroquias parroquia543=new Parroquias("543",185,"Florencio Ramírez",1,1); parroquia543.save();
        Parroquias parroquia544=new Parroquias("544",186,"Santo Domingo",1,1); parroquia544.save();
        Parroquias parroquia545=new Parroquias("545",186,"Las Piedras",1,1); parroquia545.save();
        Parroquias parroquia546=new Parroquias("546",187,"Guaraque",1,1); parroquia546.save();
        Parroquias parroquia547=new Parroquias("547",187,"Mesa de Quintero",1,1); parroquia547.save();
        Parroquias parroquia548=new Parroquias("548",187,"Río Negro",1,1); parroquia548.save();
        Parroquias parroquia549=new Parroquias("549",188,"Arapuey",1,1); parroquia549.save();
        Parroquias parroquia550=new Parroquias("550",188,"Palmira",1,1); parroquia550.save();
        Parroquias parroquia551=new Parroquias("551",189,"San Cristóbal de Torondoy",1,1); parroquia551.save();
        Parroquias parroquia552=new Parroquias("552",189,"Torondoy",1,1); parroquia552.save();
        Parroquias parroquia553=new Parroquias("553",190,"Antonio Spinetti Dini",1,1); parroquia553.save();
        Parroquias parroquia554=new Parroquias("554",190,"Arias",1,1); parroquia554.save();
        Parroquias parroquia555=new Parroquias("555",190,"Caracciolo Parra Pérez",1,1); parroquia555.save();
        Parroquias parroquia556=new Parroquias("556",190,"Domingo Peña",1,1); parroquia556.save();
        Parroquias parroquia557=new Parroquias("557",190,"El Llano",1,1); parroquia557.save();
        Parroquias parroquia558=new Parroquias("558",190,"Gonzalo Picón Febres",1,1); parroquia558.save();
        Parroquias parroquia559=new Parroquias("559",190,"Jacinto Plaza",1,1); parroquia559.save();
        Parroquias parroquia560=new Parroquias("560",190,"Juan Rodríguez Suárez",1,1); parroquia560.save();
        Parroquias parroquia561=new Parroquias("561",190,"Lasso de la Vega",1,1); parroquia561.save();
        Parroquias parroquia562=new Parroquias("562",190,"Mariano Picón Salas",1,1); parroquia562.save();
        Parroquias parroquia563=new Parroquias("563",190,"Milla",1,1); parroquia563.save();
        Parroquias parroquia564=new Parroquias("564",190,"Osuna Rodríguez",1,1); parroquia564.save();
        Parroquias parroquia565=new Parroquias("565",190,"Sagrario",1,1); parroquia565.save();
        Parroquias parroquia566=new Parroquias("566",190,"El Morro",1,1); parroquia566.save();
        Parroquias parroquia567=new Parroquias("567",190,"Los Nevados",1,1); parroquia567.save();
        Parroquias parroquia568=new Parroquias("568",191,"Andrés Eloy Blanco",1,1); parroquia568.save();
        Parroquias parroquia569=new Parroquias("569",191,"La Venta",1,1); parroquia569.save();
        Parroquias parroquia570=new Parroquias("570",191,"Piñango",1,1); parroquia570.save();
        Parroquias parroquia571=new Parroquias("571",191,"Timotes",1,1); parroquia571.save();
        Parroquias parroquia572=new Parroquias("572",192,"Eloy Paredes",1,1); parroquia572.save();
        Parroquias parroquia573=new Parroquias("573",192,"San Rafael de Alcázar",1,1); parroquia573.save();
        Parroquias parroquia574=new Parroquias("574",192,"Santa Elena de Arenales",1,1); parroquia574.save();
        Parroquias parroquia575=new Parroquias("575",193,"Santa María de Caparo",1,1); parroquia575.save();
        Parroquias parroquia576=new Parroquias("576",194,"Pueblo Llano",1,1); parroquia576.save();
        Parroquias parroquia577=new Parroquias("577",195,"Cacute",1,1); parroquia577.save();
        Parroquias parroquia578=new Parroquias("578",195,"La Toma",1,1); parroquia578.save();
        Parroquias parroquia579=new Parroquias("579",195,"Mucuchíes",1,1); parroquia579.save();
        Parroquias parroquia580=new Parroquias("580",195,"Mucurubá",1,1); parroquia580.save();
        Parroquias parroquia581=new Parroquias("581",195,"San Rafael",1,1); parroquia581.save();
        Parroquias parroquia582=new Parroquias("582",196,"Gerónimo Maldonado",1,1); parroquia582.save();
        Parroquias parroquia583=new Parroquias("583",196,"Bailadores",1,1); parroquia583.save();
        Parroquias parroquia584=new Parroquias("584",197,"Tabay",1,1); parroquia584.save();
        Parroquias parroquia585=new Parroquias("585",198,"Chiguará",1,1); parroquia585.save();
        Parroquias parroquia586=new Parroquias("586",198,"Estánquez",1,1); parroquia586.save();
        Parroquias parroquia587=new Parroquias("587",198,"Lagunillas",1,1); parroquia587.save();
        Parroquias parroquia588=new Parroquias("588",198,"La Trampa",1,1); parroquia588.save();
        Parroquias parroquia589=new Parroquias("589",198,"Pueblo Nuevo del Sur",1,1); parroquia589.save();
        Parroquias parroquia590=new Parroquias("590",198,"San Juan",1,1); parroquia590.save();
        Parroquias parroquia591=new Parroquias("591",199,"El Amparo",1,1); parroquia591.save();
        Parroquias parroquia592=new Parroquias("592",199,"El Llano",1,1); parroquia592.save();
        Parroquias parroquia593=new Parroquias("593",199,"San Francisco",1,1); parroquia593.save();
        Parroquias parroquia594=new Parroquias("594",199,"Tovar",1,1); parroquia594.save();
        Parroquias parroquia595=new Parroquias("595",200,"Independencia",1,1); parroquia595.save();
        Parroquias parroquia596=new Parroquias("596",200,"María de la Concepción Palacios Blanco",1,1); parroquia596.save();
        Parroquias parroquia597=new Parroquias("597",200,"Nueva Bolivia",1,1); parroquia597.save();
        Parroquias parroquia598=new Parroquias("598",200,"Santa Apolonia",1,1); parroquia598.save();
        Parroquias parroquia599=new Parroquias("599",201,"Caño El Tigre",1,1); parroquia599.save();
        Parroquias parroquia600=new Parroquias("600",201,"Zea",1,1); parroquia600.save();
        Parroquias parroquia601=new Parroquias("601",223,"Aragüita",1,1); parroquia601.save();
        Parroquias parroquia602=new Parroquias("602",223,"Arévalo González",1,1); parroquia602.save();
        Parroquias parroquia603=new Parroquias("603",223,"Capaya",1,1); parroquia603.save();
        Parroquias parroquia604=new Parroquias("604",223,"Caucagua",1,1); parroquia604.save();
        Parroquias parroquia605=new Parroquias("605",223,"Panaquire",1,1); parroquia605.save();
        Parroquias parroquia606=new Parroquias("606",223,"Ribas",1,1); parroquia606.save();
        Parroquias parroquia607=new Parroquias("607",223,"El Café",1,1); parroquia607.save();
        Parroquias parroquia608=new Parroquias("608",223,"Marizapa",1,1); parroquia608.save();
        Parroquias parroquia609=new Parroquias("609",224,"Cumbo",1,1); parroquia609.save();
        Parroquias parroquia610=new Parroquias("610",224,"San José de Barlovento",1,1); parroquia610.save();
        Parroquias parroquia611=new Parroquias("611",225,"El Cafetal",1,1); parroquia611.save();
        Parroquias parroquia612=new Parroquias("612",225,"Las Minas",1,1); parroquia612.save();
        Parroquias parroquia613=new Parroquias("613",225,"Nuestra Señora del Rosario",1,1); parroquia613.save();
        Parroquias parroquia614=new Parroquias("614",226,"Higuerote",1,1); parroquia614.save();
        Parroquias parroquia615=new Parroquias("615",226,"Curiepe",1,1); parroquia615.save();
        Parroquias parroquia616=new Parroquias("616",226,"Tacarigua de Brión",1,1); parroquia616.save();
        Parroquias parroquia617=new Parroquias("617",227,"Mamporal",1,1); parroquia617.save();
        Parroquias parroquia618=new Parroquias("618",228,"Carrizal",1,1); parroquia618.save();
        Parroquias parroquia619=new Parroquias("619",229,"Chacao",1,1); parroquia619.save();
        Parroquias parroquia620=new Parroquias("620",230,"Charallave",1,1); parroquia620.save();
        Parroquias parroquia621=new Parroquias("621",230,"Las Brisas",1,1); parroquia621.save();
        Parroquias parroquia622=new Parroquias("622",231,"El Hatillo",1,1); parroquia622.save();
        Parroquias parroquia623=new Parroquias("623",232,"Altagracia de la Montaña",1,1); parroquia623.save();
        Parroquias parroquia624=new Parroquias("624",232,"Cecilio Acosta",1,1); parroquia624.save();
        Parroquias parroquia625=new Parroquias("625",232,"Los Teques",1,1); parroquia625.save();
        Parroquias parroquia626=new Parroquias("626",232,"El Jarillo",1,1); parroquia626.save();
        Parroquias parroquia627=new Parroquias("627",232,"San Pedro",1,1); parroquia627.save();
        Parroquias parroquia628=new Parroquias("628",232,"Tácata",1,1); parroquia628.save();
        Parroquias parroquia629=new Parroquias("629",232,"Paracotos",1,1); parroquia629.save();
        Parroquias parroquia630=new Parroquias("630",233,"Cartanal",1,1); parroquia630.save();
        Parroquias parroquia631=new Parroquias("631",233,"Santa Teresa del Tuy",1,1); parroquia631.save();
        Parroquias parroquia632=new Parroquias("632",234,"La Democracia",1,1); parroquia632.save();
        Parroquias parroquia633=new Parroquias("633",234,"Ocumare del Tuy",1,1); parroquia633.save();
        Parroquias parroquia634=new Parroquias("634",234,"Santa Bárbara",1,1); parroquia634.save();
        Parroquias parroquia635=new Parroquias("635",235,"San Antonio de los Altos",1,1); parroquia635.save();
        Parroquias parroquia636=new Parroquias("636",236,"Río Chico",1,1); parroquia636.save();
        Parroquias parroquia637=new Parroquias("637",236,"El Guapo",1,1); parroquia637.save();
        Parroquias parroquia638=new Parroquias("638",236,"Tacarigua de la Laguna",1,1); parroquia638.save();
        Parroquias parroquia639=new Parroquias("639",236,"Paparo",1,1); parroquia639.save();
        Parroquias parroquia640=new Parroquias("640",236,"San Fernando del Guapo",1,1); parroquia640.save();
        Parroquias parroquia641=new Parroquias("641",237,"Santa Lucía del Tuy",1,1); parroquia641.save();
        Parroquias parroquia642=new Parroquias("642",238,"Cúpira",1,1); parroquia642.save();
        Parroquias parroquia643=new Parroquias("643",238,"Machurucuto",1,1); parroquia643.save();
        Parroquias parroquia644=new Parroquias("644",239,"Guarenas",1,1); parroquia644.save();
        Parroquias parroquia645=new Parroquias("645",240,"San Antonio de Yare",1,1); parroquia645.save();
        Parroquias parroquia646=new Parroquias("646",240,"San Francisco de Yare",1,1); parroquia646.save();
        Parroquias parroquia647=new Parroquias("647",241,"Leoncio Martínez",1,1); parroquia647.save();
        Parroquias parroquia648=new Parroquias("648",241,"Petare",1,1); parroquia648.save();
        Parroquias parroquia649=new Parroquias("649",241,"Caucagüita",1,1); parroquia649.save();
        Parroquias parroquia650=new Parroquias("650",241,"Filas de Mariche",1,1); parroquia650.save();
        Parroquias parroquia651=new Parroquias("651",241,"La Dolorita",1,1); parroquia651.save();
        Parroquias parroquia652=new Parroquias("652",242,"Cúa",1,1); parroquia652.save();
        Parroquias parroquia653=new Parroquias("653",242,"Nueva Cúa",1,1); parroquia653.save();
        Parroquias parroquia654=new Parroquias("654",243,"Guatire",1,1); parroquia654.save();
        Parroquias parroquia655=new Parroquias("655",243,"Bolívar",1,1); parroquia655.save();
        Parroquias parroquia656=new Parroquias("656",258,"San Antonio de Maturín",1,1); parroquia656.save();
        Parroquias parroquia657=new Parroquias("657",258,"San Francisco de Maturín",1,1); parroquia657.save();
        Parroquias parroquia658=new Parroquias("658",259,"Aguasay",1,1); parroquia658.save();
        Parroquias parroquia659=new Parroquias("659",260,"Caripito",1,1); parroquia659.save();
        Parroquias parroquia660=new Parroquias("660",261,"El Guácharo",1,1); parroquia660.save();
        Parroquias parroquia661=new Parroquias("661",261,"La Guanota",1,1); parroquia661.save();
        Parroquias parroquia662=new Parroquias("662",261,"Sabana de Piedra",1,1); parroquia662.save();
        Parroquias parroquia663=new Parroquias("663",261,"San Agustín",1,1); parroquia663.save();
        Parroquias parroquia664=new Parroquias("664",261,"Teresen",1,1); parroquia664.save();
        Parroquias parroquia665=new Parroquias("665",261,"Caripe",1,1); parroquia665.save();
        Parroquias parroquia666=new Parroquias("666",262,"Areo",1,1); parroquia666.save();
        Parroquias parroquia667=new Parroquias("667",262,"Capital Cedeño",1,1); parroquia667.save();
        Parroquias parroquia668=new Parroquias("668",262,"San Félix de Cantalicio",1,1); parroquia668.save();
        Parroquias parroquia669=new Parroquias("669",262,"Viento Fresco",1,1); parroquia669.save();
        Parroquias parroquia670=new Parroquias("670",263,"El Tejero",1,1); parroquia670.save();
        Parroquias parroquia671=new Parroquias("671",263,"Punta de Mata",1,1); parroquia671.save();
        Parroquias parroquia672=new Parroquias("672",264,"Chaguaramas",1,1); parroquia672.save();
        Parroquias parroquia673=new Parroquias("673",264,"Las Alhuacas",1,1); parroquia673.save();
        Parroquias parroquia674=new Parroquias("674",264,"Tabasca",1,1); parroquia674.save();
        Parroquias parroquia675=new Parroquias("675",264,"Temblador",1,1); parroquia675.save();
        Parroquias parroquia676=new Parroquias("676",265,"Alto de los Godos",1,1); parroquia676.save();
        Parroquias parroquia677=new Parroquias("677",265,"Boquerón",1,1); parroquia677.save();
        Parroquias parroquia678=new Parroquias("678",265,"Las Cocuizas",1,1); parroquia678.save();
        Parroquias parroquia679=new Parroquias("679",265,"La Cruz",1,1); parroquia679.save();
        Parroquias parroquia680=new Parroquias("680",265,"San Simón",1,1); parroquia680.save();
        Parroquias parroquia681=new Parroquias("681",265,"El Corozo",1,1); parroquia681.save();
        Parroquias parroquia682=new Parroquias("682",265,"El Furrial",1,1); parroquia682.save();
        Parroquias parroquia683=new Parroquias("683",265,"Jusepín",1,1); parroquia683.save();
        Parroquias parroquia684=new Parroquias("684",265,"La Pica",1,1); parroquia684.save();
        Parroquias parroquia685=new Parroquias("685",265,"San Vicente",1,1); parroquia685.save();
        Parroquias parroquia686=new Parroquias("686",266,"Aparicio",1,1); parroquia686.save();
        Parroquias parroquia687=new Parroquias("687",266,"Aragua de Maturín",1,1); parroquia687.save();
        Parroquias parroquia688=new Parroquias("688",266,"Chaguamal",1,1); parroquia688.save();
        Parroquias parroquia689=new Parroquias("689",266,"El Pinto",1,1); parroquia689.save();
        Parroquias parroquia690=new Parroquias("690",266,"Guanaguana",1,1); parroquia690.save();
        Parroquias parroquia691=new Parroquias("691",266,"La Toscana",1,1); parroquia691.save();
        Parroquias parroquia692=new Parroquias("692",266,"Taguaya",1,1); parroquia692.save();
        Parroquias parroquia693=new Parroquias("693",267,"Cachipo",1,1); parroquia693.save();
        Parroquias parroquia694=new Parroquias("694",267,"Quiriquire",1,1); parroquia694.save();
        Parroquias parroquia695=new Parroquias("695",268,"Santa Bárbara",1,1); parroquia695.save();
        Parroquias parroquia696=new Parroquias("696",269,"Barrancas",1,1); parroquia696.save();
        Parroquias parroquia697=new Parroquias("697",269,"Los Barrancos de Fajardo",1,1); parroquia697.save();
        Parroquias parroquia698=new Parroquias("698",270,"Uracoa",1,1); parroquia698.save();
        Parroquias parroquia699=new Parroquias("699",271,"Antolín del Campo",1,1); parroquia699.save();
        Parroquias parroquia700=new Parroquias("700",272,"Arismendi",1,1); parroquia700.save();
        Parroquias parroquia701=new Parroquias("701",273,"García",1,1); parroquia701.save();
        Parroquias parroquia702=new Parroquias("702",273,"Francisco Fajardo",1,1); parroquia702.save();
        Parroquias parroquia703=new Parroquias("703",274,"Bolívar",1,1); parroquia703.save();
        Parroquias parroquia704=new Parroquias("704",274,"Guevara",1,1); parroquia704.save();
        Parroquias parroquia705=new Parroquias("705",274,"Matasiete",1,1); parroquia705.save();
        Parroquias parroquia706=new Parroquias("706",274,"Santa Ana",1,1); parroquia706.save();
        Parroquias parroquia707=new Parroquias("707",274,"Sucre",1,1); parroquia707.save();
        Parroquias parroquia708=new Parroquias("708",275,"Aguirre",1,1); parroquia708.save();
        Parroquias parroquia709=new Parroquias("709",275,"Maneiro",1,1); parroquia709.save();
        Parroquias parroquia710=new Parroquias("710",276,"Adrián",1,1); parroquia710.save();
        Parroquias parroquia711=new Parroquias("711",276,"Juan Griego",1,1); parroquia711.save();
        Parroquias parroquia712=new Parroquias("712",276,"Yaguaraparo",1,1); parroquia712.save();
        Parroquias parroquia713=new Parroquias("713",277,"Porlamar",1,1); parroquia713.save();
        Parroquias parroquia714=new Parroquias("714",278,"San Francisco de Macanao",1,1); parroquia714.save();
        Parroquias parroquia715=new Parroquias("715",278,"Boca de Río",1,1); parroquia715.save();
        Parroquias parroquia716=new Parroquias("716",279,"Tubores",1,1); parroquia716.save();
        Parroquias parroquia717=new Parroquias("717",279,"Los Baleales",1,1); parroquia717.save();
        Parroquias parroquia718=new Parroquias("718",280,"Vicente Fuentes",1,1); parroquia718.save();
        Parroquias parroquia719=new Parroquias("719",280,"Villalba",1,1); parroquia719.save();
        Parroquias parroquia720=new Parroquias("720",281,"San Juan Bautista",1,1); parroquia720.save();
        Parroquias parroquia721=new Parroquias("721",281,"Zabala",1,1); parroquia721.save();
        Parroquias parroquia722=new Parroquias("722",283,"Capital Araure",1,1); parroquia722.save();
        Parroquias parroquia723=new Parroquias("723",283,"Río Acarigua",1,1); parroquia723.save();
        Parroquias parroquia724=new Parroquias("724",284,"Capital Esteller",1,1); parroquia724.save();
        Parroquias parroquia725=new Parroquias("725",284,"Uveral",1,1); parroquia725.save();
        Parroquias parroquia726=new Parroquias("726",285,"Guanare",1,1); parroquia726.save();
        Parroquias parroquia727=new Parroquias("727",285,"Córdoba",1,1); parroquia727.save();
        Parroquias parroquia728=new Parroquias("728",285,"San José de la Montaña",1,1); parroquia728.save();
        Parroquias parroquia729=new Parroquias("729",285,"San Juan de Guanaguanare",1,1); parroquia729.save();
        Parroquias parroquia730=new Parroquias("730",285,"Virgen de la Coromoto",1,1); parroquia730.save();
        Parroquias parroquia731=new Parroquias("731",286,"Guanarito",1,1); parroquia731.save();
        Parroquias parroquia732=new Parroquias("732",286,"Trinidad de la Capilla",1,1); parroquia732.save();
        Parroquias parroquia733=new Parroquias("733",286,"Divina Pastora",1,1); parroquia733.save();
        Parroquias parroquia734=new Parroquias("734",287,"Monseñor José Vicente de Unda",1,1); parroquia734.save();
        Parroquias parroquia735=new Parroquias("735",287,"Peña Blanca",1,1); parroquia735.save();
        Parroquias parroquia736=new Parroquias("736",288,"Capital Ospino",1,1); parroquia736.save();
        Parroquias parroquia737=new Parroquias("737",288,"Aparición",1,1); parroquia737.save();
        Parroquias parroquia738=new Parroquias("738",288,"La Estación",1,1); parroquia738.save();
        Parroquias parroquia739=new Parroquias("739",289,"Páez",1,1); parroquia739.save();
        Parroquias parroquia740=new Parroquias("740",289,"Payara",1,1); parroquia740.save();
        Parroquias parroquia741=new Parroquias("741",289,"Pimpinela",1,1); parroquia741.save();
        Parroquias parroquia742=new Parroquias("742",289,"Ramón Peraza",1,1); parroquia742.save();
        Parroquias parroquia743=new Parroquias("743",290,"Papelón",1,1); parroquia743.save();
        Parroquias parroquia744=new Parroquias("744",290,"Caño Delgadito",1,1); parroquia744.save();
        Parroquias parroquia745=new Parroquias("745",291,"San Genaro de Boconoito",1,1); parroquia745.save();
        Parroquias parroquia746=new Parroquias("746",291,"Antolín Tovar",1,1); parroquia746.save();
        Parroquias parroquia747=new Parroquias("747",292,"San Rafael de Onoto",1,1); parroquia747.save();
        Parroquias parroquia748=new Parroquias("748",292,"Santa Fe",1,1); parroquia748.save();
        Parroquias parroquia749=new Parroquias("749",292,"Thermo Morles",1,1); parroquia749.save();
        Parroquias parroquia750=new Parroquias("750",293,"Santa Rosalía",1,1); parroquia750.save();
        Parroquias parroquia751=new Parroquias("751",293,"Florida",1,1); parroquia751.save();
        Parroquias parroquia752=new Parroquias("752",294,"Sucre",1,1); parroquia752.save();
        Parroquias parroquia753=new Parroquias("753",294,"Concepción",1,1); parroquia753.save();
        Parroquias parroquia754=new Parroquias("754",294,"San Rafael de Palo Alzado",1,1); parroquia754.save();
        Parroquias parroquia755=new Parroquias("755",294,"Uvencio Antonio Velásquez",1,1); parroquia755.save();
        Parroquias parroquia756=new Parroquias("756",294,"San José de Saguaz",1,1); parroquia756.save();
        Parroquias parroquia757=new Parroquias("757",294,"Villa Rosa",1,1); parroquia757.save();
        Parroquias parroquia758=new Parroquias("758",295,"Turén",1,1); parroquia758.save();
        Parroquias parroquia759=new Parroquias("759",295,"Canelones",1,1); parroquia759.save();
        Parroquias parroquia760=new Parroquias("760",295,"Santa Cruz",1,1); parroquia760.save();
        Parroquias parroquia761=new Parroquias("761",295,"San Isidro Labrador",1,1); parroquia761.save();
        Parroquias parroquia762=new Parroquias("762",296,"Mariño",1,1); parroquia762.save();
        Parroquias parroquia763=new Parroquias("763",296,"Rómulo Gallegos",1,1); parroquia763.save();
        Parroquias parroquia764=new Parroquias("764",297,"San José de Aerocuar",1,1); parroquia764.save();
        Parroquias parroquia765=new Parroquias("765",297,"Tavera Acosta",1,1); parroquia765.save();
        Parroquias parroquia766=new Parroquias("766",298,"Río Caribe",1,1); parroquia766.save();
        Parroquias parroquia767=new Parroquias("767",298,"Antonio José de Sucre",1,1); parroquia767.save();
        Parroquias parroquia768=new Parroquias("768",298,"El Morro de Puerto Santo",1,1); parroquia768.save();
        Parroquias parroquia769=new Parroquias("769",298,"Puerto Santo",1,1); parroquia769.save();
        Parroquias parroquia770=new Parroquias("770",298,"San Juan de las Galdonas",1,1); parroquia770.save();
        Parroquias parroquia771=new Parroquias("771",299,"El Pilar",1,1); parroquia771.save();
        Parroquias parroquia772=new Parroquias("772",299,"El Rincón",1,1); parroquia772.save();
        Parroquias parroquia773=new Parroquias("773",299,"General Francisco Antonio Váquez",1,1); parroquia773.save();
        Parroquias parroquia774=new Parroquias("774",299,"Guaraúnos",1,1); parroquia774.save();
        Parroquias parroquia775=new Parroquias("775",299,"Tunapuicito",1,1); parroquia775.save();
        Parroquias parroquia776=new Parroquias("776",299,"Unión",1,1); parroquia776.save();
        Parroquias parroquia777=new Parroquias("777",300,"Santa Catalina",1,1); parroquia777.save();
        Parroquias parroquia778=new Parroquias("778",300,"Santa Rosa",1,1); parroquia778.save();
        Parroquias parroquia779=new Parroquias("779",300,"Santa Teresa",1,1); parroquia779.save();
        Parroquias parroquia780=new Parroquias("780",300,"Bolívar",1,1); parroquia780.save();
        Parroquias parroquia781=new Parroquias("781",300,"Maracapana",1,1); parroquia781.save();
        Parroquias parroquia782=new Parroquias("782",302,"Libertad",1,1); parroquia782.save();
        Parroquias parroquia783=new Parroquias("783",302,"El Paujil",1,1); parroquia783.save();
        Parroquias parroquia784=new Parroquias("784",302,"Yaguaraparo",1,1); parroquia784.save();
        Parroquias parroquia785=new Parroquias("785",303,"Cruz Salmerón Acosta",1,1); parroquia785.save();
        Parroquias parroquia786=new Parroquias("786",303,"Chacopata",1,1); parroquia786.save();
        Parroquias parroquia787=new Parroquias("787",303,"Manicuare",1,1); parroquia787.save();
        Parroquias parroquia788=new Parroquias("788",304,"Tunapuy",1,1); parroquia788.save();
        Parroquias parroquia789=new Parroquias("789",304,"Campo Elías",1,1); parroquia789.save();
        Parroquias parroquia790=new Parroquias("790",305,"Irapa",1,1); parroquia790.save();
        Parroquias parroquia791=new Parroquias("791",305,"Campo Claro",1,1); parroquia791.save();
        Parroquias parroquia792=new Parroquias("792",305,"Maraval",1,1); parroquia792.save();
        Parroquias parroquia793=new Parroquias("793",305,"San Antonio de Irapa",1,1); parroquia793.save();
        Parroquias parroquia794=new Parroquias("794",305,"Soro",1,1); parroquia794.save();
        Parroquias parroquia795=new Parroquias("795",306,"Mejía",1,1); parroquia795.save();
        Parroquias parroquia796=new Parroquias("796",307,"Cumanacoa",1,1); parroquia796.save();
        Parroquias parroquia797=new Parroquias("797",307,"Arenas",1,1); parroquia797.save();
        Parroquias parroquia798=new Parroquias("798",307,"Aricagua",1,1); parroquia798.save();
        Parroquias parroquia799=new Parroquias("799",307,"Cogollar",1,1); parroquia799.save();
        Parroquias parroquia800=new Parroquias("800",307,"San Fernando",1,1); parroquia800.save();
        Parroquias parroquia801=new Parroquias("801",307,"San Lorenzo",1,1); parroquia801.save();
        Parroquias parroquia802=new Parroquias("802",308,"Villa Frontado (Muelle de Cariaco)",1,1); parroquia802.save();
        Parroquias parroquia803=new Parroquias("803",308,"Catuaro",1,1); parroquia803.save();
        Parroquias parroquia804=new Parroquias("804",308,"Rendón",1,1); parroquia804.save();
        Parroquias parroquia805=new Parroquias("805",308,"San Cruz",1,1); parroquia805.save();
        Parroquias parroquia806=new Parroquias("806",308,"Santa María",1,1); parroquia806.save();
        Parroquias parroquia807=new Parroquias("807",309,"Altagracia",1,1); parroquia807.save();
        Parroquias parroquia808=new Parroquias("808",309,"Santa Inés",1,1); parroquia808.save();
        Parroquias parroquia809=new Parroquias("809",309,"Valentín Valiente",1,1); parroquia809.save();
        Parroquias parroquia810=new Parroquias("810",309,"Ayacucho",1,1); parroquia810.save();
        Parroquias parroquia811=new Parroquias("811",309,"San Juan",1,1); parroquia811.save();
        Parroquias parroquia812=new Parroquias("812",309,"Raúl Leoni",1,1); parroquia812.save();
        Parroquias parroquia813=new Parroquias("813",309,"Gran Mariscal",1,1); parroquia813.save();
        Parroquias parroquia814=new Parroquias("814",310,"Cristóbal Colón",1,1); parroquia814.save();
        Parroquias parroquia815=new Parroquias("815",310,"Bideau",1,1); parroquia815.save();
        Parroquias parroquia816=new Parroquias("816",310,"Punta de Piedras",1,1); parroquia816.save();
        Parroquias parroquia817=new Parroquias("817",310,"Güiria",1,1); parroquia817.save();
        Parroquias parroquia818=new Parroquias("818",341,"Andrés Bello",1,1); parroquia818.save();
        Parroquias parroquia819=new Parroquias("819",342,"Antonio Rómulo Costa",1,1); parroquia819.save();
        Parroquias parroquia820=new Parroquias("820",343,"Ayacucho",1,1); parroquia820.save();
        Parroquias parroquia821=new Parroquias("821",343,"Rivas Berti",1,1); parroquia821.save();
        Parroquias parroquia822=new Parroquias("822",343,"San Pedro del Río",1,1); parroquia822.save();
        Parroquias parroquia823=new Parroquias("823",344,"Bolívar",1,1); parroquia823.save();
        Parroquias parroquia824=new Parroquias("824",344,"Palotal",1,1); parroquia824.save();
        Parroquias parroquia825=new Parroquias("825",344,"General Juan Vicente Gómez",1,1); parroquia825.save();
        Parroquias parroquia826=new Parroquias("826",344,"Isaías Medina Angarita",1,1); parroquia826.save();
        Parroquias parroquia827=new Parroquias("827",345,"Cárdenas",1,1); parroquia827.save();
        Parroquias parroquia828=new Parroquias("828",345,"Amenodoro Ángel Lamus",1,1); parroquia828.save();
        Parroquias parroquia829=new Parroquias("829",345,"La Florida",1,1); parroquia829.save();
        Parroquias parroquia830=new Parroquias("830",346,"Córdoba",1,1); parroquia830.save();
        Parroquias parroquia831=new Parroquias("831",347,"Fernández Feo",1,1); parroquia831.save();
        Parroquias parroquia832=new Parroquias("832",347,"Alberto Adriani",1,1); parroquia832.save();
        Parroquias parroquia833=new Parroquias("833",347,"Santo Domingo",1,1); parroquia833.save();
        Parroquias parroquia834=new Parroquias("834",348,"Francisco de Miranda",1,1); parroquia834.save();
        Parroquias parroquia835=new Parroquias("835",349,"García de Hevia",1,1); parroquia835.save();
        Parroquias parroquia836=new Parroquias("836",349,"Boca de Grita",1,1); parroquia836.save();
        Parroquias parroquia837=new Parroquias("837",349,"José Antonio Páez",1,1); parroquia837.save();
        Parroquias parroquia838=new Parroquias("838",350,"Guásimos",1,1); parroquia838.save();
        Parroquias parroquia839=new Parroquias("839",351,"Independencia",1,1); parroquia839.save();
        Parroquias parroquia840=new Parroquias("840",351,"Juan Germán Roscio",1,1); parroquia840.save();
        Parroquias parroquia841=new Parroquias("841",351,"Román Cárdenas",1,1); parroquia841.save();
        Parroquias parroquia842=new Parroquias("842",352,"Jáuregui",1,1); parroquia842.save();
        Parroquias parroquia843=new Parroquias("843",352,"Emilio Constantino Guerrero",1,1); parroquia843.save();
        Parroquias parroquia844=new Parroquias("844",352,"Monseñor Miguel Antonio Salas",1,1); parroquia844.save();
        Parroquias parroquia845=new Parroquias("845",353,"José María Vargas",1,1); parroquia845.save();
        Parroquias parroquia846=new Parroquias("846",354,"Junín",1,1); parroquia846.save();
        Parroquias parroquia847=new Parroquias("847",354,"La Petrólea",1,1); parroquia847.save();
        Parroquias parroquia848=new Parroquias("848",354,"Quinimarí",1,1); parroquia848.save();
        Parroquias parroquia849=new Parroquias("849",354,"Bramón",1,1); parroquia849.save();
        Parroquias parroquia850=new Parroquias("850",355,"Libertad",1,1); parroquia850.save();
        Parroquias parroquia851=new Parroquias("851",355,"Cipriano Castro",1,1); parroquia851.save();
        Parroquias parroquia852=new Parroquias("852",355,"Manuel Felipe Rugeles",1,1); parroquia852.save();
        Parroquias parroquia853=new Parroquias("853",356,"Libertador",1,1); parroquia853.save();
        Parroquias parroquia854=new Parroquias("854",356,"Doradas",1,1); parroquia854.save();
        Parroquias parroquia855=new Parroquias("855",356,"Emeterio Ochoa",1,1); parroquia855.save();
        Parroquias parroquia856=new Parroquias("856",356,"San Joaquín de Navay",1,1); parroquia856.save();
        Parroquias parroquia857=new Parroquias("857",357,"Lobatera",1,1); parroquia857.save();
        Parroquias parroquia858=new Parroquias("858",357,"Constitución",1,1); parroquia858.save();
        Parroquias parroquia859=new Parroquias("859",358,"Michelena",1,1); parroquia859.save();
        Parroquias parroquia860=new Parroquias("860",359,"Panamericano",1,1); parroquia860.save();
        Parroquias parroquia861=new Parroquias("861",359,"La Palmita",1,1); parroquia861.save();
        Parroquias parroquia862=new Parroquias("862",360,"Pedro María Ureña",1,1); parroquia862.save();
        Parroquias parroquia863=new Parroquias("863",360,"Nueva Arcadia",1,1); parroquia863.save();
        Parroquias parroquia864=new Parroquias("864",361,"Delicias",1,1); parroquia864.save();
        Parroquias parroquia865=new Parroquias("865",361,"Pecaya",1,1); parroquia865.save();
        Parroquias parroquia866=new Parroquias("866",362,"Samuel Darío Maldonado",1,1); parroquia866.save();
        Parroquias parroquia867=new Parroquias("867",362,"Boconó",1,1); parroquia867.save();
        Parroquias parroquia868=new Parroquias("868",362,"Hernández",1,1); parroquia868.save();
        Parroquias parroquia869=new Parroquias("869",363,"La Concordia",1,1); parroquia869.save();
        Parroquias parroquia870=new Parroquias("870",363,"San Juan Bautista",1,1); parroquia870.save();
        Parroquias parroquia871=new Parroquias("871",363,"Pedro María Morantes",1,1); parroquia871.save();
        Parroquias parroquia872=new Parroquias("872",363,"San Sebastián",1,1); parroquia872.save();
        Parroquias parroquia873=new Parroquias("873",363,"Dr. Francisco Romero Lobo",1,1); parroquia873.save();
        Parroquias parroquia874=new Parroquias("874",364,"Seboruco",1,1); parroquia874.save();
        Parroquias parroquia875=new Parroquias("875",365,"Simón Rodríguez",1,1); parroquia875.save();
        Parroquias parroquia876=new Parroquias("876",366,"Sucre",1,1); parroquia876.save();
        Parroquias parroquia877=new Parroquias("877",366,"Eleazar López Contreras",1,1); parroquia877.save();
        Parroquias parroquia878=new Parroquias("878",366,"San Pablo",1,1); parroquia878.save();
        Parroquias parroquia879=new Parroquias("879",367,"Torbes",1,1); parroquia879.save();
        Parroquias parroquia880=new Parroquias("880",368,"Uribante",1,1); parroquia880.save();
        Parroquias parroquia881=new Parroquias("881",368,"Cárdenas",1,1); parroquia881.save();
        Parroquias parroquia882=new Parroquias("882",368,"Juan Pablo Peñalosa",1,1); parroquia882.save();
        Parroquias parroquia883=new Parroquias("883",368,"Potosí",1,1); parroquia883.save();
        Parroquias parroquia884=new Parroquias("884",369,"San Judas Tadeo",1,1); parroquia884.save();
        Parroquias parroquia885=new Parroquias("885",370,"Araguaney",1,1); parroquia885.save();
        Parroquias parroquia886=new Parroquias("886",370,"El Jaguito",1,1); parroquia886.save();
        Parroquias parroquia887=new Parroquias("887",370,"La Esperanza",1,1); parroquia887.save();
        Parroquias parroquia888=new Parroquias("888",370,"Santa Isabel",1,1); parroquia888.save();
        Parroquias parroquia889=new Parroquias("889",371,"Boconó",1,1); parroquia889.save();
        Parroquias parroquia890=new Parroquias("890",371,"El Carmen",1,1); parroquia890.save();
        Parroquias parroquia891=new Parroquias("891",371,"Mosquey",1,1); parroquia891.save();
        Parroquias parroquia892=new Parroquias("892",371,"Ayacucho",1,1); parroquia892.save();
        Parroquias parroquia893=new Parroquias("893",371,"Burbusay",1,1); parroquia893.save();
        Parroquias parroquia894=new Parroquias("894",371,"General Ribas",1,1); parroquia894.save();
        Parroquias parroquia895=new Parroquias("895",371,"Guaramacal",1,1); parroquia895.save();
        Parroquias parroquia896=new Parroquias("896",371,"Vega de Guaramacal",1,1); parroquia896.save();
        Parroquias parroquia897=new Parroquias("897",371,"Monseñor Jáuregui",1,1); parroquia897.save();
        Parroquias parroquia898=new Parroquias("898",371,"Rafael Rangel",1,1); parroquia898.save();
        Parroquias parroquia899=new Parroquias("899",371,"San Miguel",1,1); parroquia899.save();
        Parroquias parroquia900=new Parroquias("900",371,"San José",1,1); parroquia900.save();
        Parroquias parroquia901=new Parroquias("901",372,"Sabana Grande",1,1); parroquia901.save();
        Parroquias parroquia902=new Parroquias("902",372,"Cheregüé",1,1); parroquia902.save();
        Parroquias parroquia903=new Parroquias("903",372,"Granados",1,1); parroquia903.save();
        Parroquias parroquia904=new Parroquias("904",373,"Arnoldo Gabaldón",1,1); parroquia904.save();
        Parroquias parroquia905=new Parroquias("905",373,"Bolivia",1,1); parroquia905.save();
        Parroquias parroquia906=new Parroquias("906",373,"Carrillo",1,1); parroquia906.save();
        Parroquias parroquia907=new Parroquias("907",373,"Cegarra",1,1); parroquia907.save();
        Parroquias parroquia908=new Parroquias("908",373,"Chejendé",1,1); parroquia908.save();
        Parroquias parroquia909=new Parroquias("909",373,"Manuel Salvador Ulloa",1,1); parroquia909.save();
        Parroquias parroquia910=new Parroquias("910",373,"San José",1,1); parroquia910.save();
        Parroquias parroquia911=new Parroquias("911",374,"Carache",1,1); parroquia911.save();
        Parroquias parroquia912=new Parroquias("912",374,"La Concepción",1,1); parroquia912.save();
        Parroquias parroquia913=new Parroquias("913",374,"Cuicas",1,1); parroquia913.save();
        Parroquias parroquia914=new Parroquias("914",374,"Panamericana",1,1); parroquia914.save();
        Parroquias parroquia915=new Parroquias("915",374,"Santa Cruz",1,1); parroquia915.save();
        Parroquias parroquia916=new Parroquias("916",375,"Escuque",1,1); parroquia916.save();
        Parroquias parroquia917=new Parroquias("917",375,"La Unión",1,1); parroquia917.save();
        Parroquias parroquia918=new Parroquias("918",375,"Santa Rita",1,1); parroquia918.save();
        Parroquias parroquia919=new Parroquias("919",375,"Sabana Libre",1,1); parroquia919.save();
        Parroquias parroquia920=new Parroquias("920",376,"El Socorro",1,1); parroquia920.save();
        Parroquias parroquia921=new Parroquias("921",376,"Los Caprichos",1,1); parroquia921.save();
        Parroquias parroquia922=new Parroquias("922",376,"Antonio José de Sucre",1,1); parroquia922.save();
        Parroquias parroquia923=new Parroquias("923",377,"Campo Elías",1,1); parroquia923.save();
        Parroquias parroquia924=new Parroquias("924",377,"Arnoldo Gabaldón",1,1); parroquia924.save();
        Parroquias parroquia925=new Parroquias("925",378,"Santa Apolonia",1,1); parroquia925.save();
        Parroquias parroquia926=new Parroquias("926",378,"El Progreso",1,1); parroquia926.save();
        Parroquias parroquia927=new Parroquias("927",378,"La Ceiba",1,1); parroquia927.save();
        Parroquias parroquia928=new Parroquias("928",378,"Tres de Febrero",1,1); parroquia928.save();
        Parroquias parroquia929=new Parroquias("929",379,"El Dividive",1,1); parroquia929.save();
        Parroquias parroquia930=new Parroquias("930",379,"Agua Santa",1,1); parroquia930.save();
        Parroquias parroquia931=new Parroquias("931",379,"Agua Caliente",1,1); parroquia931.save();
        Parroquias parroquia932=new Parroquias("932",379,"El Cenizo",1,1); parroquia932.save();
        Parroquias parroquia933=new Parroquias("933",379,"Valerita",1,1); parroquia933.save();
        Parroquias parroquia934=new Parroquias("934",380,"Monte Carmelo",1,1); parroquia934.save();
        Parroquias parroquia935=new Parroquias("935",380,"Buena Vista",1,1); parroquia935.save();
        Parroquias parroquia936=new Parroquias("936",380,"Santa María del Horcón",1,1); parroquia936.save();
        Parroquias parroquia937=new Parroquias("937",381,"Motatán",1,1); parroquia937.save();
        Parroquias parroquia938=new Parroquias("938",381,"El Baño",1,1); parroquia938.save();
        Parroquias parroquia939=new Parroquias("939",381,"Jalisco",1,1); parroquia939.save();
        Parroquias parroquia940=new Parroquias("940",382,"Pampán",1,1); parroquia940.save();
        Parroquias parroquia941=new Parroquias("941",382,"Flor de Patria",1,1); parroquia941.save();
        Parroquias parroquia942=new Parroquias("942",382,"La Paz",1,1); parroquia942.save();
        Parroquias parroquia943=new Parroquias("943",382,"Santa Ana",1,1); parroquia943.save();
        Parroquias parroquia944=new Parroquias("944",383,"Pampanito",1,1); parroquia944.save();
        Parroquias parroquia945=new Parroquias("945",383,"La Concepción",1,1); parroquia945.save();
        Parroquias parroquia946=new Parroquias("946",383,"Pampanito II",1,1); parroquia946.save();
        Parroquias parroquia947=new Parroquias("947",384,"Betijoque",1,1); parroquia947.save();
        Parroquias parroquia948=new Parroquias("948",384,"José Gregorio Hernández",1,1); parroquia948.save();
        Parroquias parroquia949=new Parroquias("949",384,"La Pueblita",1,1); parroquia949.save();
        Parroquias parroquia950=new Parroquias("950",384,"Los Cedros",1,1); parroquia950.save();
        Parroquias parroquia951=new Parroquias("951",385,"Carvajal",1,1); parroquia951.save();
        Parroquias parroquia952=new Parroquias("952",385,"Campo Alegre",1,1); parroquia952.save();
        Parroquias parroquia953=new Parroquias("953",385,"Antonio Nicolás Briceño",1,1); parroquia953.save();
        Parroquias parroquia954=new Parroquias("954",385,"José Leonardo Suárez",1,1); parroquia954.save();
        Parroquias parroquia955=new Parroquias("955",386,"Sabana de Mendoza",1,1); parroquia955.save();
        Parroquias parroquia956=new Parroquias("956",386,"Junín",1,1); parroquia956.save();
        Parroquias parroquia957=new Parroquias("957",386,"Valmore Rodríguez",1,1); parroquia957.save();
        Parroquias parroquia958=new Parroquias("958",386,"El Paraíso",1,1); parroquia958.save();
        Parroquias parroquia959=new Parroquias("959",387,"Andrés Linares",1,1); parroquia959.save();
        Parroquias parroquia960=new Parroquias("960",387,"Chiquinquirá",1,1); parroquia960.save();
        Parroquias parroquia961=new Parroquias("961",387,"Cristóbal Mendoza",1,1); parroquia961.save();
        Parroquias parroquia962=new Parroquias("962",387,"Cruz Carrillo",1,1); parroquia962.save();
        Parroquias parroquia963=new Parroquias("963",387,"Matriz",1,1); parroquia963.save();
        Parroquias parroquia964=new Parroquias("964",387,"Monseñor Carrillo",1,1); parroquia964.save();
        Parroquias parroquia965=new Parroquias("965",387,"Tres Esquinas",1,1); parroquia965.save();
        Parroquias parroquia966=new Parroquias("966",388,"Cabimbú",1,1); parroquia966.save();
        Parroquias parroquia967=new Parroquias("967",388,"Jajó",1,1); parroquia967.save();
        Parroquias parroquia968=new Parroquias("968",388,"La Mesa de Esnujaque",1,1); parroquia968.save();
        Parroquias parroquia969=new Parroquias("969",388,"Santiago",1,1); parroquia969.save();
        Parroquias parroquia970=new Parroquias("970",388,"Tuñame",1,1); parroquia970.save();
        Parroquias parroquia971=new Parroquias("971",388,"La Quebrada",1,1); parroquia971.save();
        Parroquias parroquia972=new Parroquias("972",389,"Juan Ignacio Montilla",1,1); parroquia972.save();
        Parroquias parroquia973=new Parroquias("973",389,"La Beatriz",1,1); parroquia973.save();
        Parroquias parroquia974=new Parroquias("974",389,"La Puerta",1,1); parroquia974.save();
        Parroquias parroquia975=new Parroquias("975",389,"Mendoza del Valle de Momboy",1,1); parroquia975.save();
        Parroquias parroquia976=new Parroquias("976",389,"Mercedes Díaz",1,1); parroquia976.save();
        Parroquias parroquia977=new Parroquias("977",389,"San Luis",1,1); parroquia977.save();
        Parroquias parroquia978=new Parroquias("978",390,"Caraballeda",1,1); parroquia978.save();
        Parroquias parroquia979=new Parroquias("979",390,"Carayaca",1,1); parroquia979.save();
        Parroquias parroquia980=new Parroquias("980",390,"Carlos Soublette",1,1); parroquia980.save();
        Parroquias parroquia981=new Parroquias("981",390,"Caruao Chuspa",1,1); parroquia981.save();
        Parroquias parroquia982=new Parroquias("982",390,"Catia La Mar",1,1); parroquia982.save();
        Parroquias parroquia983=new Parroquias("983",390,"El Junko",1,1); parroquia983.save();
        Parroquias parroquia984=new Parroquias("984",390,"La Guaira",1,1); parroquia984.save();
        Parroquias parroquia985=new Parroquias("985",390,"Macuto",1,1); parroquia985.save();
        Parroquias parroquia986=new Parroquias("986",390,"Maiquetía",1,1); parroquia986.save();
        Parroquias parroquia987=new Parroquias("987",390,"Naiguatá",1,1); parroquia987.save();
        Parroquias parroquia988=new Parroquias("988",390,"Urimare",1,1); parroquia988.save();
        Parroquias parroquia989=new Parroquias("989",391,"Arístides Bastidas",1,1); parroquia989.save();
        Parroquias parroquia990=new Parroquias("990",392,"Bolívar",1,1); parroquia990.save();
        Parroquias parroquia991=new Parroquias("991",407,"Chivacoa",1,1); parroquia991.save();
        Parroquias parroquia992=new Parroquias("992",407,"Campo Elías",1,1); parroquia992.save();
        Parroquias parroquia993=new Parroquias("993",408,"Cocorote",1,1); parroquia993.save();
        Parroquias parroquia994=new Parroquias("994",409,"Independencia",1,1); parroquia994.save();
        Parroquias parroquia995=new Parroquias("995",410,"José Antonio Páez",1,1); parroquia995.save();
        Parroquias parroquia996=new Parroquias("996",411,"La Trinidad",1,1); parroquia996.save();
        Parroquias parroquia997=new Parroquias("997",412,"Manuel Monge",1,1); parroquia997.save();
        Parroquias parroquia998=new Parroquias("998",413,"Salóm",1,1); parroquia998.save();
        Parroquias parroquia999=new Parroquias("999",413,"Temerla",1,1); parroquia999.save();
        Parroquias parroquia1000=new Parroquias("1000",413,"Nirgua",1,1); parroquia1000.save();
        Parroquias parroquia1001=new Parroquias("1001",414,"San Andrés",1,1); parroquia1001.save();
        Parroquias parroquia1002=new Parroquias("1002",414,"Yaritagua",1,1); parroquia1002.save();
        Parroquias parroquia1003=new Parroquias("1003",415,"San Javier",1,1); parroquia1003.save();
        Parroquias parroquia1004=new Parroquias("1004",415,"Albarico",1,1); parroquia1004.save();
        Parroquias parroquia1005=new Parroquias("1005",415,"San Felipe",1,1); parroquia1005.save();
        Parroquias parroquia1006=new Parroquias("1006",416,"Sucre",1,1); parroquia1006.save();
        Parroquias parroquia1007=new Parroquias("1007",417,"Urachiche",1,1); parroquia1007.save();
        Parroquias parroquia1008=new Parroquias("1008",418,"El Guayabo",1,1); parroquia1008.save();
        Parroquias parroquia1009=new Parroquias("1009",418,"Farriar",1,1); parroquia1009.save();
        Parroquias parroquia1010=new Parroquias("1010",441,"Isla de Toas",1,1); parroquia1010.save();
        Parroquias parroquia1011=new Parroquias("1011",441,"Monagas",1,1); parroquia1011.save();
        Parroquias parroquia1012=new Parroquias("1012",442,"San Timoteo",1,1); parroquia1012.save();
        Parroquias parroquia1013=new Parroquias("1013",442,"General Urdaneta",1,1); parroquia1013.save();
        Parroquias parroquia1014=new Parroquias("1014",442,"Libertador",1,1); parroquia1014.save();
        Parroquias parroquia1015=new Parroquias("1015",442,"Marcelino Briceño",1,1); parroquia1015.save();
        Parroquias parroquia1016=new Parroquias("1016",442,"Pueblo Nuevo",1,1); parroquia1016.save();
        Parroquias parroquia1017=new Parroquias("1017",442,"Manuel Guanipa Matos",1,1); parroquia1017.save();
        Parroquias parroquia1018=new Parroquias("1018",443,"Ambrosio",1,1); parroquia1018.save();
        Parroquias parroquia1019=new Parroquias("1019",443,"Carmen Herrera",1,1); parroquia1019.save();
        Parroquias parroquia1020=new Parroquias("1020",443,"La Rosa",1,1); parroquia1020.save();
        Parroquias parroquia1021=new Parroquias("1021",443,"Germán Ríos Linares",1,1); parroquia1021.save();
        Parroquias parroquia1022=new Parroquias("1022",443,"San Benito",1,1); parroquia1022.save();
        Parroquias parroquia1023=new Parroquias("1023",443,"Rómulo Betancourt",1,1); parroquia1023.save();
        Parroquias parroquia1024=new Parroquias("1024",443,"Jorge Hernández",1,1); parroquia1024.save();
        Parroquias parroquia1025=new Parroquias("1025",443,"Punta Gorda",1,1); parroquia1025.save();
        Parroquias parroquia1026=new Parroquias("1026",443,"Arístides Calvani",1,1); parroquia1026.save();
        Parroquias parroquia1027=new Parroquias("1027",444,"Encontrados",1,1); parroquia1027.save();
        Parroquias parroquia1028=new Parroquias("1028",444,"Udón Pérez",1,1); parroquia1028.save();
        Parroquias parroquia1029=new Parroquias("1029",445,"Moralito",1,1); parroquia1029.save();
        Parroquias parroquia1030=new Parroquias("1030",445,"San Carlos del Zulia",1,1); parroquia1030.save();
        Parroquias parroquia1031=new Parroquias("1031",445,"Santa Cruz del Zulia",1,1); parroquia1031.save();
        Parroquias parroquia1032=new Parroquias("1032",445,"Santa Bárbara",1,1); parroquia1032.save();
        Parroquias parroquia1033=new Parroquias("1033",445,"Urribarrí",1,1); parroquia1033.save();
        Parroquias parroquia1034=new Parroquias("1034",446,"Carlos Quevedo",1,1); parroquia1034.save();
        Parroquias parroquia1035=new Parroquias("1035",446,"Francisco Javier Pulgar",1,1); parroquia1035.save();
        Parroquias parroquia1036=new Parroquias("1036",446,"Simón Rodríguez",1,1); parroquia1036.save();
        Parroquias parroquia1037=new Parroquias("1037",446,"Guamo-Gavilanes",1,1); parroquia1037.save();
        Parroquias parroquia1038=new Parroquias("1038",448,"La Concepción",1,1); parroquia1038.save();
        Parroquias parroquia1039=new Parroquias("1039",448,"San José",1,1); parroquia1039.save();
        Parroquias parroquia1040=new Parroquias("1040",448,"Mariano Parra León",1,1); parroquia1040.save();
        Parroquias parroquia1041=new Parroquias("1041",448,"José Ramón Yépez",1,1); parroquia1041.save();
        Parroquias parroquia1042=new Parroquias("1042",449,"Jesús María Semprún",1,1); parroquia1042.save();
        Parroquias parroquia1043=new Parroquias("1043",449,"Barí",1,1); parroquia1043.save();
        Parroquias parroquia1044=new Parroquias("1044",450,"Concepción",1,1); parroquia1044.save();
        Parroquias parroquia1045=new Parroquias("1045",450,"Andrés Bello",1,1); parroquia1045.save();
        Parroquias parroquia1046=new Parroquias("1046",450,"Chiquinquirá",1,1); parroquia1046.save();
        Parroquias parroquia1047=new Parroquias("1047",450,"El Carmelo",1,1); parroquia1047.save();
        Parroquias parroquia1048=new Parroquias("1048",450,"Potreritos",1,1); parroquia1048.save();
        Parroquias parroquia1049=new Parroquias("1049",451,"Libertad",1,1); parroquia1049.save();
        Parroquias parroquia1050=new Parroquias("1050",451,"Alonso de Ojeda",1,1); parroquia1050.save();
        Parroquias parroquia1051=new Parroquias("1051",451,"Venezuela",1,1); parroquia1051.save();
        Parroquias parroquia1052=new Parroquias("1052",451,"Eleazar López Contreras",1,1); parroquia1052.save();
        Parroquias parroquia1053=new Parroquias("1053",451,"Campo Lara",1,1); parroquia1053.save();
        Parroquias parroquia1054=new Parroquias("1054",452,"Bartolomé de las Casas",1,1); parroquia1054.save();
        Parroquias parroquia1055=new Parroquias("1055",452,"Libertad",1,1); parroquia1055.save();
        Parroquias parroquia1056=new Parroquias("1056",452,"Río Negro",1,1); parroquia1056.save();
        Parroquias parroquia1057=new Parroquias("1057",452,"San José de Perijá",1,1); parroquia1057.save();
        Parroquias parroquia1058=new Parroquias("1058",453,"San Rafael",1,1); parroquia1058.save();
        Parroquias parroquia1059=new Parroquias("1059",453,"La Sierrita",1,1); parroquia1059.save();
        Parroquias parroquia1060=new Parroquias("1060",453,"Las Parcelas",1,1); parroquia1060.save();
        Parroquias parroquia1061=new Parroquias("1061",453,"Luis de Vicente",1,1); parroquia1061.save();
        Parroquias parroquia1062=new Parroquias("1062",453,"Monseñor Marcos Sergio Godoy",1,1); parroquia1062.save();
        Parroquias parroquia1063=new Parroquias("1063",453,"Ricaurte",1,1); parroquia1063.save();
        Parroquias parroquia1064=new Parroquias("1064",453,"Tamare",1,1); parroquia1064.save();
        Parroquias parroquia1065=new Parroquias("1065",454,"Antonio Borjas Romero",1,1); parroquia1065.save();
        Parroquias parroquia1066=new Parroquias("1066",454,"Bolívar",1,1); parroquia1066.save();
        Parroquias parroquia1067=new Parroquias("1067",454,"Cacique Mara",1,1); parroquia1067.save();
        Parroquias parroquia1068=new Parroquias("1068",454,"Carracciolo Parra Pérez",1,1); parroquia1068.save();
        Parroquias parroquia1069=new Parroquias("1069",454,"Cecilio Acosta",1,1); parroquia1069.save();
        Parroquias parroquia1070=new Parroquias("1070",454,"Cristo de Aranza",1,1); parroquia1070.save();
        Parroquias parroquia1071=new Parroquias("1071",454,"Coquivacoa",1,1); parroquia1071.save();
        Parroquias parroquia1072=new Parroquias("1072",454,"Chiquinquirá",1,1); parroquia1072.save();
        Parroquias parroquia1073=new Parroquias("1073",454,"Francisco Eugenio Bustamante",1,1); parroquia1073.save();
        Parroquias parroquia1074=new Parroquias("1074",454,"Idelfonzo Vásquez",1,1); parroquia1074.save();
        Parroquias parroquia1075=new Parroquias("1075",454,"Juana de Ávila",1,1); parroquia1075.save();
        Parroquias parroquia1076=new Parroquias("1076",454,"Luis Hurtado Higuera",1,1); parroquia1076.save();
        Parroquias parroquia1077=new Parroquias("1077",454,"Manuel Dagnino",1,1); parroquia1077.save();
        Parroquias parroquia1078=new Parroquias("1078",454,"Olegario Villalobos",1,1); parroquia1078.save();
        Parroquias parroquia1079=new Parroquias("1079",454,"Raúl Leoni",1,1); parroquia1079.save();
        Parroquias parroquia1080=new Parroquias("1080",454,"Santa Lucía",1,1); parroquia1080.save();
        Parroquias parroquia1081=new Parroquias("1081",454,"Venancio Pulgar",1,1); parroquia1081.save();
        Parroquias parroquia1082=new Parroquias("1082",454,"San Isidro",1,1); parroquia1082.save();
        Parroquias parroquia1083=new Parroquias("1083",455,"Altagracia",1,1); parroquia1083.save();
        Parroquias parroquia1084=new Parroquias("1084",455,"Faría",1,1); parroquia1084.save();
        Parroquias parroquia1085=new Parroquias("1085",455,"Ana María Campos",1,1); parroquia1085.save();
        Parroquias parroquia1086=new Parroquias("1086",455,"San Antonio",1,1); parroquia1086.save();
        Parroquias parroquia1087=new Parroquias("1087",455,"San José",1,1); parroquia1087.save();
        Parroquias parroquia1088=new Parroquias("1088",456,"Donaldo García",1,1); parroquia1088.save();
        Parroquias parroquia1089=new Parroquias("1089",456,"El Rosario",1,1); parroquia1089.save();
        Parroquias parroquia1090=new Parroquias("1090",456,"Sixto Zambrano",1,1); parroquia1090.save();
        Parroquias parroquia1091=new Parroquias("1091",457,"San Francisco",1,1); parroquia1091.save();
        Parroquias parroquia1092=new Parroquias("1092",457,"El Bajo",1,1); parroquia1092.save();
        Parroquias parroquia1093=new Parroquias("1093",457,"Domitila Flores",1,1); parroquia1093.save();
        Parroquias parroquia1094=new Parroquias("1094",457,"Francisco Ochoa",1,1); parroquia1094.save();
        Parroquias parroquia1095=new Parroquias("1095",457,"Los Cortijos",1,1); parroquia1095.save();
        Parroquias parroquia1096=new Parroquias("1096",457,"Marcial Hernández",1,1); parroquia1096.save();
        Parroquias parroquia1097=new Parroquias("1097",458,"Santa Rita",1,1); parroquia1097.save();
        Parroquias parroquia1098=new Parroquias("1098",458,"El Mene",1,1); parroquia1098.save();
        Parroquias parroquia1099=new Parroquias("1099",458,"Pedro Lucas Urribarrí",1,1); parroquia1099.save();
        Parroquias parroquia1100=new Parroquias("1100",458,"José Cenobio Urribarrí",1,1); parroquia1100.save();
        Parroquias parroquia1101=new Parroquias("1101",459,"Rafael Maria Baralt",1,1); parroquia1101.save();
        Parroquias parroquia1102=new Parroquias("1102",459,"Manuel Manrique",1,1); parroquia1102.save();
        Parroquias parroquia1103=new Parroquias("1103",459,"Rafael Urdaneta",1,1); parroquia1103.save();
        Parroquias parroquia1104=new Parroquias("1104",460,"Bobures",1,1); parroquia1104.save();
        Parroquias parroquia1105=new Parroquias("1105",460,"Gibraltar",1,1); parroquia1105.save();
        Parroquias parroquia1106=new Parroquias("1106",460,"Heras",1,1); parroquia1106.save();
        Parroquias parroquia1107=new Parroquias("1107",460,"Monseñor Arturo Álvarez",1,1); parroquia1107.save();
        Parroquias parroquia1108=new Parroquias("1108",460,"Rómulo Gallegos",1,1); parroquia1108.save();
        Parroquias parroquia1109=new Parroquias("1109",460,"El Batey",1,1); parroquia1109.save();
        Parroquias parroquia1110=new Parroquias("1110",461,"Rafael Urdaneta",1,1); parroquia1110.save();
        Parroquias parroquia1111=new Parroquias("1111",461,"La Victoria",1,1); parroquia1111.save();
        Parroquias parroquia1112=new Parroquias("1112",461,"Raúl Cuenca",1,1); parroquia1112.save();
        Parroquias parroquia1113=new Parroquias("1113",447,"Sinamaica",1,1); parroquia1113.save();
        Parroquias parroquia1114=new Parroquias("1114",447,"Alta Guajira",1,1); parroquia1114.save();
        Parroquias parroquia1115=new Parroquias("1115",447,"Elías Sánchez Rubio",1,1); parroquia1115.save();
        Parroquias parroquia1116=new Parroquias("1116",447,"Guajira",1,1); parroquia1116.save();
        Parroquias parroquia1117=new Parroquias("1117",462,"Altagracia",1,1); parroquia1117.save();
        Parroquias parroquia1118=new Parroquias("1118",462,"Antímano",1,1); parroquia1118.save();
        Parroquias parroquia1119=new Parroquias("1119",462,"Caricuao",1,1); parroquia1119.save();
        Parroquias parroquia1120=new Parroquias("1120",462,"Catedral",1,1); parroquia1120.save();
        Parroquias parroquia1121=new Parroquias("1121",462,"Coche",1,1); parroquia1121.save();
        Parroquias parroquia1122=new Parroquias("1122",462,"El Junquito",1,1); parroquia1122.save();
        Parroquias parroquia1123=new Parroquias("1123",462,"El Paraíso",1,1); parroquia1123.save();
        Parroquias parroquia1124=new Parroquias("1124",462,"El Recreo",1,1); parroquia1124.save();
        Parroquias parroquia1125=new Parroquias("1125",462,"El Valle",1,1); parroquia1125.save();
        Parroquias parroquia1126=new Parroquias("1126",462,"La Candelaria",1,1); parroquia1126.save();
        Parroquias parroquia1127=new Parroquias("1127",462,"La Pastora",1,1); parroquia1127.save();
        Parroquias parroquia1128=new Parroquias("1128",462,"La Vega",1,1); parroquia1128.save();
        Parroquias parroquia1129=new Parroquias("1129",462,"Macarao",1,1); parroquia1129.save();
        Parroquias parroquia1130=new Parroquias("1130",462,"San Agustín",1,1); parroquia1130.save();
        Parroquias parroquia1131=new Parroquias("1131",462,"San Bernardino",1,1); parroquia1131.save();
        Parroquias parroquia1132=new Parroquias("1132",462,"San José",1,1); parroquia1132.save();
        Parroquias parroquia1133=new Parroquias("1133",462,"San Juan",1,1); parroquia1133.save();
        Parroquias parroquia1134=new Parroquias("1134",462,"San Pedro",1,1); parroquia1134.save();
        Parroquias parroquia1135=new Parroquias("1135",462,"Santa Rosalía",1,1); parroquia1135.save();
        Parroquias parroquia1136=new Parroquias("1136",462,"Santa Teresa",1,1); parroquia1136.save();
        Parroquias parroquia1137=new Parroquias("1137",462,"Sucre (Catia)",1,1); parroquia1137.save();
        Parroquias parroquia1138=new Parroquias("1138",462,"23 de enero",1,1); parroquia1138.save();



    }

    private void setObjetoConexion() {


        ObjetoConexion objeto1= new ObjetoConexion( 1,2, "18000692860","RESD EL SOLAR DEL SAMAN",
                1,"SERVICIOS GUARVINACA C.A.","APTO","3", "3-B", "C1-ALFR", 1, 1);
        objeto1.save();

        ObjetoConexion objeto2= new ObjetoConexion( 2,1, "18000691893", "PSTE 00GM0165",
                1,"","CASA 09","PB", "", "C1-ALFR", 1, 1);
         objeto2.save();

        ObjetoConexion objeto3= new ObjetoConexion( 3,2, "18000075986","RESD EL SOLAR DEL SAMAN",
                1,"SERVICIOS GUARVINACA C.A.","APTO","3", "3-B", "C1-ALFR", 1, 1);
        objeto3.save();

        ObjetoConexion objeto4= new ObjetoConexion( 4,1, "18000642984", "PSTE 00GM0165",
                1,"","CASA 09","PB", "", "C1-ALFR", 1, 1);
        objeto4.save();


    }

    private void setMunicipios() {

        Municipios municipio1= new Municipios( "1",1,"Alto Orinoco",1,1); municipio1.save();
        Municipios municipio2= new Municipios( "2",1,"Atabapo",1,1); municipio2.save();
        Municipios municipio3= new Municipios( "3",1,"Atures",1,1); municipio3.save();
        Municipios municipio4= new Municipios( "4",1,"Autana",1,1); municipio4.save();
        Municipios municipio5= new Municipios( "5",1,"Manapiare",1,1); municipio5.save();
        Municipios municipio6= new Municipios( "6",1,"Maroa",1,1); municipio6.save();
        Municipios municipio7= new Municipios( "7",1,"Río Negro",1,1); municipio7.save();
        Municipios municipio8= new Municipios( "8",2,"Anaco",1,1); municipio8.save();
        Municipios municipio9= new Municipios( "9",2,"Aragua",1,1); municipio9.save();
        Municipios municipio10= new Municipios( "10",2,"Manuel Ezequiel Bruzual",1,1); municipio10.save();
        Municipios municipio11= new Municipios( "11",2,"Diego Bautista Urbaneja",1,1); municipio11.save();
        Municipios municipio12= new Municipios( "12",2,"Fernando Peñalver",1,1); municipio12.save();
        Municipios municipio13= new Municipios( "13",2,"Francisco Del Carmen Carvajal",1,1); municipio13.save();
        Municipios municipio14= new Municipios( "14",2,"General Sir Arthur McGregor",1,1); municipio14.save();
        Municipios municipio15= new Municipios( "15",2,"Guanta",1,1); municipio15.save();
        Municipios municipio16= new Municipios( "16",2,"Independencia",1,1); municipio16.save();
        Municipios municipio17= new Municipios( "17",2,"José Gregorio Monagas",1,1); municipio17.save();
        Municipios municipio18= new Municipios( "18",2,"Juan Antonio Sotillo",1,1); municipio18.save();
        Municipios municipio19= new Municipios( "19",2,"Juan Manuel Cajigal",1,1); municipio19.save();
        Municipios municipio20= new Municipios( "20",2,"Libertad",1,1); municipio20.save();
        Municipios municipio21= new Municipios( "21",2,"Francisco de Miranda",1,1); municipio21.save();
        Municipios municipio22= new Municipios( "22",2,"Pedro María Freites",1,1); municipio22.save();
        Municipios municipio23= new Municipios( "23",2,"Píritu",1,1); municipio23.save();
        Municipios municipio24= new Municipios( "24",2,"San José de Guanipa",1,1); municipio24.save();
        Municipios municipio25= new Municipios( "25",2,"San Juan de Capistrano",1,1); municipio25.save();
        Municipios municipio26= new Municipios( "26",2,"Santa Ana",1,1); municipio26.save();
        Municipios municipio27= new Municipios( "27",2,"Simón Bolívar",1,1); municipio27.save();
        Municipios municipio28= new Municipios( "28",2,"Simón Rodríguez",1,1); municipio28.save();
        Municipios municipio29= new Municipios( "29",3,"Achaguas",1,1); municipio29.save();
        Municipios municipio30= new Municipios( "30",3,"Biruaca",1,1); municipio30.save();
        Municipios municipio31= new Municipios( "31",3,"Muñóz",1,1); municipio31.save();
        Municipios municipio32= new Municipios( "32",3,"Páez",1,1); municipio32.save();
        Municipios municipio33= new Municipios( "33",3,"Pedro Camejo",1,1); municipio33.save();
        Municipios municipio34= new Municipios( "34",3,"Rómulo Gallegos",1,1); municipio34.save();
        Municipios municipio35= new Municipios( "35",3,"San Fernando",1,1); municipio35.save();
        Municipios municipio36= new Municipios( "36",4,"Atanasio Girardot",1,1); municipio36.save();
        Municipios municipio37= new Municipios( "37",4,"Bolívar",1,1); municipio37.save();
        Municipios municipio38= new Municipios( "38",4,"Camatagua",1,1); municipio38.save();
        Municipios municipio39= new Municipios( "39",4,"Francisco Linares Alcántara",1,1); municipio39.save();
        Municipios municipio40= new Municipios( "40",4,"José Ángel Lamas",1,1); municipio40.save();
        Municipios municipio41= new Municipios( "41",4,"José Félix Ribas",1,1); municipio41.save();
        Municipios municipio42= new Municipios( "42",4,"José Rafael Revenga",1,1); municipio42.save();
        Municipios municipio43= new Municipios( "43",4,"Libertador",1,1); municipio43.save();
        Municipios municipio44= new Municipios( "44",4,"Mario Briceño Iragorry",1,1); municipio44.save();
        Municipios municipio45= new Municipios( "45",4,"Ocumare de la Costa de Oro",1,1); municipio45.save();
        Municipios municipio46= new Municipios( "46",4,"San Casimiro",1,1); municipio46.save();
        Municipios municipio47= new Municipios( "47",4,"San Sebastián",1,1); municipio47.save();
        Municipios municipio48= new Municipios( "48",4,"Santiago Mariño",1,1); municipio48.save();
        Municipios municipio49= new Municipios( "49",4,"Santos Michelena",1,1); municipio49.save();
        Municipios municipio50= new Municipios( "50",4,"Sucre",1,1); municipio50.save();
        Municipios municipio51= new Municipios( "51",4,"Tovar",1,1); municipio51.save();
        Municipios municipio52= new Municipios( "52",4,"Urdaneta",1,1); municipio52.save();
        Municipios municipio53= new Municipios( "53",4,"Zamora",1,1); municipio53.save();
        Municipios municipio54= new Municipios( "54",5,"Alberto Arvelo Torrealba",1,1); municipio54.save();
        Municipios municipio55= new Municipios( "55",5,"Andrés Eloy Blanco",1,1); municipio55.save();
        Municipios municipio56= new Municipios( "56",5,"Antonio José de Sucre",1,1); municipio56.save();
        Municipios municipio57= new Municipios( "57",5,"Arismendi",1,1); municipio57.save();
        Municipios municipio58= new Municipios( "58",5,"Barinas",1,1); municipio58.save();
        Municipios municipio59= new Municipios( "59",5,"Bolívar",1,1); municipio59.save();
        Municipios municipio60= new Municipios( "60",5,"Cruz Paredes",1,1); municipio60.save();
        Municipios municipio61= new Municipios( "61",5,"Ezequiel Zamora",1,1); municipio61.save();
        Municipios municipio62= new Municipios( "62",5,"Obispos",1,1); municipio62.save();
        Municipios municipio63= new Municipios( "63",5,"Pedraza",1,1); municipio63.save();
        Municipios municipio64= new Municipios( "64",5,"Rojas",1,1); municipio64.save();
        Municipios municipio65= new Municipios( "65",5,"Sosa",1,1); municipio65.save();
        Municipios municipio66= new Municipios( "66",6,"Caroní",1,1); municipio66.save();
        Municipios municipio67= new Municipios( "67",6,"Cedeño",1,1); municipio67.save();
        Municipios municipio68= new Municipios( "68",6,"El Callao",1,1); municipio68.save();
        Municipios municipio69= new Municipios( "69",6,"Gran Sabana",1,1); municipio69.save();
        Municipios municipio70= new Municipios( "70",6,"Heres",1,1); municipio70.save();
        Municipios municipio71= new Municipios( "71",6,"Piar",1,1); municipio71.save();
        Municipios municipio72= new Municipios( "72",6,"Angostura (Raúl Leoni)",1,1); municipio72.save();
        Municipios municipio73= new Municipios( "73",6,"Roscio",1,1); municipio73.save();
        Municipios municipio74= new Municipios( "74",6,"Sifontes",1,1); municipio74.save();
        Municipios municipio75= new Municipios( "75",6,"Sucre",1,1); municipio75.save();
        Municipios municipio76= new Municipios( "76",6,"Padre Pedro Chien",1,1); municipio76.save();
        Municipios municipio77= new Municipios( "77",7,"Bejuma",1,1); municipio77.save();
        Municipios municipio78= new Municipios( "78",7,"Carlos Arvelo",1,1); municipio78.save();
        Municipios municipio79= new Municipios( "79",7,"Diego Ibarra",1,1); municipio79.save();
        Municipios municipio80= new Municipios( "80",7,"Guacara",1,1); municipio80.save();
        Municipios municipio81= new Municipios( "81",7,"Juan José Mora",1,1); municipio81.save();
        Municipios municipio82= new Municipios( "82",7,"Libertador",1,1); municipio82.save();
        Municipios municipio83= new Municipios( "83",7,"Los Guayos",1,1); municipio83.save();
        Municipios municipio84= new Municipios( "84",7,"Miranda",1,1); municipio84.save();
        Municipios municipio85= new Municipios( "85",7,"Montalbán",1,1); municipio85.save();
        Municipios municipio86= new Municipios( "86",7,"Naguanagua",1,1); municipio86.save();
        Municipios municipio87= new Municipios( "87",7,"Puerto Cabello",1,1); municipio87.save();
        Municipios municipio88= new Municipios( "88",7,"San Diego",1,1); municipio88.save();
        Municipios municipio89= new Municipios( "89",7,"San Joaquín",1,1); municipio89.save();
        Municipios municipio90= new Municipios( "90",7,"Valencia",1,1); municipio90.save();
        Municipios municipio91= new Municipios( "91",8,"Anzoátegui",1,1); municipio91.save();
        Municipios municipio92= new Municipios( "92",8,"Tinaquillo",1,1); municipio92.save();
        Municipios municipio93= new Municipios( "93",8,"Girardot",1,1); municipio93.save();
        Municipios municipio94= new Municipios( "94",8,"Lima Blanco",1,1); municipio94.save();
        Municipios municipio95= new Municipios( "95",8,"Pao de San Juan Bautista",1,1); municipio95.save();
        Municipios municipio96= new Municipios( "96",8,"Ricaurte",1,1); municipio96.save();
        Municipios municipio97= new Municipios( "97",8,"Rómulo Gallegos",1,1); municipio97.save();
        Municipios municipio98= new Municipios( "98",8,"San Carlos",1,1); municipio98.save();
        Municipios municipio99= new Municipios( "99",8,"Tinaco",1,1); municipio99.save();
        Municipios municipio100= new Municipios( "100",9,"Antonio Díaz",1,1); municipio100.save();
        Municipios municipio101= new Municipios( "101",9,"Casacoima",1,1); municipio101.save();
        Municipios municipio102= new Municipios( "102",9,"Pedernales",1,1); municipio102.save();
        Municipios municipio103= new Municipios( "103",9,"Tucupita",1,1); municipio103.save();
        Municipios municipio104= new Municipios( "104",10,"Acosta",1,1); municipio104.save();
        Municipios municipio105= new Municipios( "105",10,"Bolívar",1,1); municipio105.save();
        Municipios municipio106= new Municipios( "106",10,"Buchivacoa",1,1); municipio106.save();
        Municipios municipio107= new Municipios( "107",10,"Cacique Manaure",1,1); municipio107.save();
        Municipios municipio108= new Municipios( "108",10,"Carirubana",1,1); municipio108.save();
        Municipios municipio109= new Municipios( "109",10,"Colina",1,1); municipio109.save();
        Municipios municipio110= new Municipios( "110",10,"Dabajuro",1,1); municipio110.save();
        Municipios municipio111= new Municipios( "111",10,"Democracia",1,1); municipio111.save();
        Municipios municipio112= new Municipios( "112",10,"Falcón",1,1); municipio112.save();
        Municipios municipio113= new Municipios( "113",10,"Federación",1,1); municipio113.save();
        Municipios municipio114= new Municipios( "114",10,"Jacura",1,1); municipio114.save();
        Municipios municipio115= new Municipios( "115",10,"José Laurencio Silva",1,1); municipio115.save();
        Municipios municipio116= new Municipios( "116",10,"Los Taques",1,1); municipio116.save();
        Municipios municipio117= new Municipios( "117",10,"Mauroa",1,1); municipio117.save();
        Municipios municipio118= new Municipios( "118",10,"Miranda",1,1); municipio118.save();
        Municipios municipio119= new Municipios( "119",10,"Monseñor Iturriza",1,1); municipio119.save();
        Municipios municipio120= new Municipios( "120",10,"Palmasola",1,1); municipio120.save();
        Municipios municipio121= new Municipios( "121",10,"Petit",1,1); municipio121.save();
        Municipios municipio122= new Municipios( "122",10,"Píritu",1,1); municipio122.save();
        Municipios municipio123= new Municipios( "123",10,"San Francisco",1,1); municipio123.save();
        Municipios municipio124= new Municipios( "124",10,"Sucre",1,1); municipio124.save();
        Municipios municipio125= new Municipios( "125",10,"Tocópero",1,1); municipio125.save();
        Municipios municipio126= new Municipios( "126",10,"Unión",1,1); municipio126.save();
        Municipios municipio127= new Municipios( "127",10,"Urumaco",1,1); municipio127.save();
        Municipios municipio128= new Municipios( "128",10,"Zamora",1,1); municipio128.save();
        Municipios municipio129= new Municipios( "129",11,"Camaguán",1,1); municipio129.save();
        Municipios municipio130= new Municipios( "130",11,"Chaguaramas",1,1); municipio130.save();
        Municipios municipio131= new Municipios( "131",11,"El Socorro",1,1); municipio131.save();
        Municipios municipio132= new Municipios( "132",11,"José Félix Ribas",1,1); municipio132.save();
        Municipios municipio133= new Municipios( "133",11,"José Tadeo Monagas",1,1); municipio133.save();
        Municipios municipio134= new Municipios( "134",11,"Juan Germán Roscio",1,1); municipio134.save();
        Municipios municipio135= new Municipios( "135",11,"Julián Mellado",1,1); municipio135.save();
        Municipios municipio136= new Municipios( "136",11,"Las Mercedes",1,1); municipio136.save();
        Municipios municipio137= new Municipios( "137",11,"Leonardo Infante",1,1); municipio137.save();
        Municipios municipio138= new Municipios( "138",11,"Pedro Zaraza",1,1); municipio138.save();
        Municipios municipio139= new Municipios( "139",11,"Ortíz",1,1); municipio139.save();
        Municipios municipio140= new Municipios( "140",11,"San Gerónimo de Guayabal",1,1); municipio140.save();
        Municipios municipio141= new Municipios( "141",11,"San José de Guaribe",1,1); municipio141.save();
        Municipios municipio142= new Municipios( "142",11,"Santa María de Ipire",1,1); municipio142.save();
        Municipios municipio143= new Municipios( "143",11,"Sebastián Francisco de Miranda",1,1); municipio143.save();
        Municipios municipio144= new Municipios( "144",12,"Andrés Eloy Blanco",1,1); municipio144.save();
        Municipios municipio145= new Municipios( "145",12,"Crespo",1,1); municipio145.save();
        Municipios municipio146= new Municipios( "146",12,"Iribarren",1,1); municipio146.save();
        Municipios municipio147= new Municipios( "147",12,"Jiménez",1,1); municipio147.save();
        Municipios municipio148= new Municipios( "148",12,"Morán",1,1); municipio148.save();
        Municipios municipio149= new Municipios( "149",12,"Palavecino",1,1); municipio149.save();
        Municipios municipio150= new Municipios( "150",12,"Simón Planas",1,1); municipio150.save();
        Municipios municipio151= new Municipios( "151",12,"Torres",1,1); municipio151.save();
        Municipios municipio152= new Municipios( "152",12,"Urdaneta",1,1); municipio152.save();
        Municipios municipio153= new Municipios( "179",13,"Alberto Adriani",1,1); municipio153.save();
        Municipios municipio154= new Municipios( "180",13,"Andrés Bello",1,1); municipio154.save();
        Municipios municipio155= new Municipios( "181",13,"Antonio Pinto Salinas",1,1); municipio155.save();
        Municipios municipio156= new Municipios( "182",13,"Aricagua",1,1); municipio156.save();
        Municipios municipio157= new Municipios( "183",13,"Arzobispo Chacón",1,1); municipio157.save();
        Municipios municipio158= new Municipios( "184",13,"Campo Elías",1,1); municipio158.save();
        Municipios municipio159= new Municipios( "185",13,"Caracciolo Parra Olmedo",1,1); municipio159.save();
        Municipios municipio160= new Municipios( "186",13,"Cardenal Quintero",1,1); municipio160.save();
        Municipios municipio161= new Municipios( "187",13,"Guaraque",1,1); municipio161.save();
        Municipios municipio162= new Municipios( "188",13,"Julio César Salas",1,1); municipio162.save();
        Municipios municipio163= new Municipios( "189",13,"Justo Briceño",1,1); municipio163.save();
        Municipios municipio164= new Municipios( "190",13,"Libertador",1,1); municipio164.save();
        Municipios municipio165= new Municipios( "191",13,"Miranda",1,1); municipio165.save();
        Municipios municipio166= new Municipios( "192",13,"Obispo Ramos de Lora",1,1); municipio166.save();
        Municipios municipio167= new Municipios( "193",13,"Padre Noguera",1,1); municipio167.save();
        Municipios municipio168= new Municipios( "194",13,"Pueblo Llano",1,1); municipio168.save();
        Municipios municipio169= new Municipios( "195",13,"Rangel",1,1); municipio169.save();
        Municipios municipio170= new Municipios( "196",13,"Rivas Dávila",1,1); municipio170.save();
        Municipios municipio171= new Municipios( "197",13,"Santos Marquina",1,1); municipio171.save();
        Municipios municipio172= new Municipios( "198",13,"Sucre",1,1); municipio172.save();
        Municipios municipio173= new Municipios( "199",13,"Tovar",1,1); municipio173.save();
        Municipios municipio174= new Municipios( "200",13,"Tulio Febres Cordero",1,1); municipio174.save();
        Municipios municipio175= new Municipios( "201",13,"Zea",1,1); municipio175.save();
        Municipios municipio176= new Municipios( "223",14,"Acevedo",1,1); municipio176.save();
        Municipios municipio177= new Municipios( "224",14,"Andrés Bello",1,1); municipio177.save();
        Municipios municipio178= new Municipios( "225",14,"Baruta",1,1); municipio178.save();
        Municipios municipio179= new Municipios( "226",14,"Brión",1,1); municipio179.save();
        Municipios municipio180= new Municipios( "227",14,"Buroz",1,1); municipio180.save();
        Municipios municipio181= new Municipios( "228",14,"Carrizal",1,1); municipio181.save();
        Municipios municipio182= new Municipios( "229",14,"Chacao",1,1); municipio182.save();
        Municipios municipio183= new Municipios( "230",14,"Cristóbal Rojas",1,1); municipio183.save();
        Municipios municipio184= new Municipios( "231",14,"El Hatillo",1,1); municipio184.save();
        Municipios municipio185= new Municipios( "232",14,"Guaicaipuro",1,1); municipio185.save();
        Municipios municipio186= new Municipios( "233",14,"Independencia",1,1); municipio186.save();
        Municipios municipio187= new Municipios( "234",14,"Lander",1,1); municipio187.save();
        Municipios municipio188= new Municipios( "235",14,"Los Salias",1,1); municipio188.save();
        Municipios municipio189= new Municipios( "236",14,"Páez",1,1); municipio189.save();
        Municipios municipio190= new Municipios( "237",14,"Paz Castillo",1,1); municipio190.save();
        Municipios municipio191= new Municipios( "238",14,"Pedro Gual",1,1); municipio191.save();
        Municipios municipio192= new Municipios( "239",14,"Plaza",1,1); municipio192.save();
        Municipios municipio193= new Municipios( "240",14,"Simón Bolívar",1,1); municipio193.save();
        Municipios municipio194= new Municipios( "241",14,"Sucre",1,1); municipio194.save();
        Municipios municipio195= new Municipios( "242",14,"Urdaneta",1,1); municipio195.save();
        Municipios municipio196= new Municipios( "243",14,"Zamora",1,1); municipio196.save();
        Municipios municipio197= new Municipios( "258",15,"Acosta",1,1); municipio197.save();
        Municipios municipio198= new Municipios( "259",15,"Aguasay",1,1); municipio198.save();
        Municipios municipio199= new Municipios( "260",15,"Bolívar",1,1); municipio199.save();
        Municipios municipio200= new Municipios( "261",15,"Caripe",1,1); municipio200.save();
        Municipios municipio201= new Municipios( "262",15,"Cedeño",1,1); municipio201.save();
        Municipios municipio202= new Municipios( "263",15,"Ezequiel Zamora",1,1); municipio202.save();
        Municipios municipio203= new Municipios( "264",15,"Libertador",1,1); municipio203.save();
        Municipios municipio204= new Municipios( "265",15,"Maturín",1,1); municipio204.save();
        Municipios municipio205= new Municipios( "266",15,"Piar",1,1); municipio205.save();
        Municipios municipio206= new Municipios( "267",15,"Punceres",1,1); municipio206.save();
        Municipios municipio207= new Municipios( "268",15,"Santa Bárbara",1,1); municipio207.save();
        Municipios municipio208= new Municipios( "269",15,"Sotillo",1,1); municipio208.save();
        Municipios municipio209= new Municipios( "270",15,"Uracoa",1,1); municipio209.save();
        Municipios municipio210= new Municipios( "271",16,"Antolín del Campo",1,1); municipio210.save();
        Municipios municipio211= new Municipios( "272",16,"Arismendi",1,1); municipio211.save();
        Municipios municipio212= new Municipios( "273",16,"García",1,1); municipio212.save();
        Municipios municipio213= new Municipios( "274",16,"Gómez",1,1); municipio213.save();
        Municipios municipio214= new Municipios( "275",16,"Maneiro",1,1); municipio214.save();
        Municipios municipio215= new Municipios( "276",16,"Marcano",1,1); municipio215.save();
        Municipios municipio216= new Municipios( "277",16,"Mariño",1,1); municipio216.save();
        Municipios municipio217= new Municipios( "278",16,"Península de Macanao",1,1); municipio217.save();
        Municipios municipio218= new Municipios( "279",16,"Tubores",1,1); municipio218.save();
        Municipios municipio219= new Municipios( "280",16,"Villalba",1,1); municipio219.save();
        Municipios municipio220= new Municipios( "281",16,"Díaz",1,1); municipio220.save();
        Municipios municipio221= new Municipios( "282",17,"Agua Blanca",1,1); municipio221.save();
        Municipios municipio222= new Municipios( "283",17,"Araure",1,1); municipio222.save();
        Municipios municipio223= new Municipios( "284",17,"Esteller",1,1); municipio223.save();
        Municipios municipio224= new Municipios( "285",17,"Guanare",1,1); municipio224.save();
        Municipios municipio225= new Municipios( "286",17,"Guanarito",1,1); municipio225.save();
        Municipios municipio226= new Municipios( "287",17,"Monseñor José Vicente de Unda",1,1); municipio226.save();
        Municipios municipio227= new Municipios( "288",17,"Ospino",1,1); municipio227.save();
        Municipios municipio228= new Municipios( "289",17,"Páez",1,1); municipio228.save();
        Municipios municipio229= new Municipios( "290",17,"Papelón",1,1); municipio229.save();
        Municipios municipio230= new Municipios( "291",17,"San Genaro de Boconoíto",1,1); municipio230.save();
        Municipios municipio231= new Municipios( "292",17,"San Rafael de Onoto",1,1); municipio231.save();
        Municipios municipio232= new Municipios( "293",17,"Santa Rosalía",1,1); municipio232.save();
        Municipios municipio233= new Municipios( "294",17,"Sucre",1,1); municipio233.save();
        Municipios municipio234= new Municipios( "295",17,"Turén",1,1); municipio234.save();
        Municipios municipio235= new Municipios( "296",18,"Andrés Eloy Blanco",1,1); municipio235.save();
        Municipios municipio236= new Municipios( "297",18,"Andrés Mata",1,1); municipio236.save();
        Municipios municipio237= new Municipios( "298",18,"Arismendi",1,1); municipio237.save();
        Municipios municipio238= new Municipios( "299",18,"Benítez",1,1); municipio238.save();
        Municipios municipio239= new Municipios( "300",18,"Bermúdez",1,1); municipio239.save();
        Municipios municipio240= new Municipios( "301",18,"Bolívar",1,1); municipio240.save();
        Municipios municipio241= new Municipios( "302",18,"Cajigal",1,1); municipio241.save();
        Municipios municipio242= new Municipios( "303",18,"Cruz Salmerón Acosta",1,1); municipio242.save();
        Municipios municipio243= new Municipios( "304",18,"Libertador",1,1); municipio243.save();
        Municipios municipio244= new Municipios( "305",18,"Mariño",1,1); municipio244.save();
        Municipios municipio245= new Municipios( "306",18,"Mejía",1,1); municipio245.save();
        Municipios municipio246= new Municipios( "307",18,"Montes",1,1); municipio246.save();
        Municipios municipio247= new Municipios( "308",18,"Ribero",1,1); municipio247.save();
        Municipios municipio248= new Municipios( "309",18,"Sucre",1,1); municipio248.save();
        Municipios municipio249= new Municipios( "310",18,"Valdéz",1,1); municipio249.save();
        Municipios municipio250= new Municipios( "341",19,"Andrés Bello",1,1); municipio250.save();
        Municipios municipio251= new Municipios( "342",19,"Antonio Rómulo Costa",1,1); municipio251.save();
        Municipios municipio252= new Municipios( "343",19,"Ayacucho",1,1); municipio252.save();
        Municipios municipio253= new Municipios( "344",19,"Bolívar",1,1); municipio253.save();
        Municipios municipio254= new Municipios( "345",19,"Cárdenas",1,1); municipio254.save();
        Municipios municipio255= new Municipios( "346",19,"Córdoba",1,1); municipio255.save();
        Municipios municipio256= new Municipios( "347",19,"Fernández Feo",1,1); municipio256.save();
        Municipios municipio257= new Municipios( "348",19,"Francisco de Miranda",1,1); municipio257.save();
        Municipios municipio258= new Municipios( "349",19,"García de Hevia",1,1); municipio258.save();
        Municipios municipio259= new Municipios( "350",19,"Guásimos",1,1); municipio259.save();
        Municipios municipio260= new Municipios( "351",19,"Independencia",1,1); municipio260.save();
        Municipios municipio261= new Municipios( "352",19,"Jáuregui",1,1); municipio261.save();
        Municipios municipio262= new Municipios( "353",19,"José María Vargas",1,1); municipio262.save();
        Municipios municipio263= new Municipios( "354",19,"Junín",1,1); municipio263.save();
        Municipios municipio264= new Municipios( "355",19,"Libertad",1,1); municipio264.save();
        Municipios municipio265= new Municipios( "356",19,"Libertador",1,1); municipio265.save();
        Municipios municipio266= new Municipios( "357",19,"Lobatera",1,1); municipio266.save();
        Municipios municipio267= new Municipios( "358",19,"Michelena",1,1); municipio267.save();
        Municipios municipio268= new Municipios( "359",19,"Panamericano",1,1); municipio268.save();
        Municipios municipio269= new Municipios( "360",19,"Pedro María Ureña",1,1); municipio269.save();
        Municipios municipio270= new Municipios( "361",19,"Rafael Urdaneta",1,1); municipio270.save();
        Municipios municipio271= new Municipios( "362",19,"Samuel Darío Maldonado",1,1); municipio271.save();
        Municipios municipio272= new Municipios( "363",19,"San Cristóbal",1,1); municipio272.save();
        Municipios municipio273= new Municipios( "364",19,"Seboruco",1,1); municipio273.save();
        Municipios municipio274= new Municipios( "365",19,"Simón Rodríguez",1,1); municipio274.save();
        Municipios municipio275= new Municipios( "366",19,"Sucre",1,1); municipio275.save();
        Municipios municipio276= new Municipios( "367",19,"Torbes",1,1); municipio276.save();
        Municipios municipio277= new Municipios( "368",19,"Uribante",1,1); municipio277.save();
        Municipios municipio278= new Municipios( "369",19,"San Judas Tadeo",1,1); municipio278.save();
        Municipios municipio279= new Municipios( "370",20,"Andrés Bello",1,1); municipio279.save();
        Municipios municipio280= new Municipios( "371",20,"Boconó",1,1); municipio280.save();
        Municipios municipio281= new Municipios( "372",20,"Bolívar",1,1); municipio281.save();
        Municipios municipio282= new Municipios( "373",20,"Candelaria",1,1); municipio282.save();
        Municipios municipio283= new Municipios( "374",20,"Carache",1,1); municipio283.save();
        Municipios municipio284= new Municipios( "375",20,"Escuque",1,1); municipio284.save();
        Municipios municipio285= new Municipios( "376",20,"José Felipe Márquez Cañizalez",1,1); municipio285.save();
        Municipios municipio286= new Municipios( "377",20,"Juan Vicente Campos Elías",1,1); municipio286.save();
        Municipios municipio287= new Municipios( "378",20,"La Ceiba",1,1); municipio287.save();
        Municipios municipio288= new Municipios( "379",20,"Miranda",1,1); municipio288.save();
        Municipios municipio289= new Municipios( "380",20,"Monte Carmelo",1,1); municipio289.save();
        Municipios municipio290= new Municipios( "381",20,"Motatán",1,1); municipio290.save();
        Municipios municipio291= new Municipios( "382",20,"Pampán",1,1); municipio291.save();
        Municipios municipio292= new Municipios( "383",20,"Pampanito",1,1); municipio292.save();
        Municipios municipio293= new Municipios( "384",20,"Rafael Rangel",1,1); municipio293.save();
        Municipios municipio294= new Municipios( "385",20,"San Rafael de Carvajal",1,1); municipio294.save();
        Municipios municipio295= new Municipios( "386",20,"Sucre",1,1); municipio295.save();
        Municipios municipio296= new Municipios( "387",20,"Trujillo",1,1); municipio296.save();
        Municipios municipio297= new Municipios( "388",20,"Urdaneta",1,1); municipio297.save();
        Municipios municipio298= new Municipios( "389",20,"Valera",1,1); municipio298.save();
        Municipios municipio299= new Municipios( "390",21,"Vargas",1,1); municipio299.save();
        Municipios municipio300= new Municipios( "391",22,"Arístides Bastidas",1,1); municipio300.save();
        Municipios municipio301= new Municipios( "392",22,"Bolívar",1,1); municipio301.save();
        Municipios municipio302= new Municipios( "407",22,"Bruzual",1,1); municipio302.save();
        Municipios municipio303= new Municipios( "408",22,"Cocorote",1,1); municipio303.save();
        Municipios municipio304= new Municipios( "409",22,"Independencia",1,1); municipio304.save();
        Municipios municipio305= new Municipios( "410",22,"José Antonio Páez",1,1); municipio305.save();
        Municipios municipio306= new Municipios( "411",22,"La Trinidad",1,1); municipio306.save();
        Municipios municipio307= new Municipios( "412",22,"Manuel Monge",1,1); municipio307.save();
        Municipios municipio308= new Municipios( "413",22,"Nirgua",1,1); municipio308.save();
        Municipios municipio309= new Municipios( "414",22,"Peña",1,1); municipio309.save();
        Municipios municipio310= new Municipios( "415",22,"San Felipe",1,1); municipio310.save();
        Municipios municipio311= new Municipios( "416",22,"Sucre",1,1); municipio311.save();
        Municipios municipio312= new Municipios( "417",22,"Urachiche",1,1); municipio312.save();
        Municipios municipio313= new Municipios( "418",22,"José Joaquín Veroes",1,1); municipio313.save();
        Municipios municipio314= new Municipios( "441",23,"Almirante Padilla",1,1); municipio314.save();
        Municipios municipio315= new Municipios( "442",23,"Baralt",1,1); municipio315.save();
        Municipios municipio316= new Municipios( "443",23,"Cabimas",1,1); municipio316.save();
        Municipios municipio317= new Municipios( "444",23,"Catatumbo",1,1); municipio317.save();
        Municipios municipio318= new Municipios( "445",23,"Colón",1,1); municipio318.save();
        Municipios municipio319= new Municipios( "446",23,"Francisco Javier Pulgar",1,1); municipio319.save();
        Municipios municipio320= new Municipios( "447",23,"Páez",1,1); municipio320.save();
        Municipios municipio321= new Municipios( "448",23,"Jesús Enrique Losada",1,1); municipio321.save();
        Municipios municipio322= new Municipios( "449",23,"Jesús María Semprún",1,1); municipio322.save();
        Municipios municipio323= new Municipios( "450",23,"La Cañada de Urdaneta",1,1); municipio323.save();
        Municipios municipio324= new Municipios( "451",23,"Lagunillas",1,1); municipio324.save();
        Municipios municipio325= new Municipios( "452",23,"Machiques de Perijá",1,1); municipio325.save();
        Municipios municipio326= new Municipios( "453",23,"Mara",1,1); municipio326.save();
        Municipios municipio327= new Municipios( "454",23,"Maracaibo",1,1); municipio327.save();
        Municipios municipio328= new Municipios( "455",23,"Miranda",1,1); municipio328.save();
        Municipios municipio329= new Municipios( "456",23,"Rosario de Perijá",1,1); municipio329.save();
        Municipios municipio330= new Municipios( "457",23,"San Francisco",1,1); municipio330.save();
        Municipios municipio331= new Municipios( "458",23,"Santa Rita",1,1); municipio331.save();
        Municipios municipio332= new Municipios( "459",23,"Simón Bolívar",1,1); municipio332.save();
        Municipios municipio333= new Municipios( "460",23,"Sucre",1,1); municipio333.save();
        Municipios municipio334= new Municipios( "461",23,"Valmore Rodríguez",1,1); municipio334.save();
        Municipios municipio335= new Municipios( "462",24,"Libertador",1,1); municipio335.save();

    }

    private void setMedidores() {

        Medidores medidor1= new Medidores(1,1,1,5,3,"1132","101735470","19002211848"," 7006945886","9002797027",1,1,1,"");
        medidor1.save();

        Medidores medidor2= new Medidores(2,2,1,5,3,"1132","101851238","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor2.save();

        Medidores medidor3= new Medidores(3,2,1,5,3,"1132","100876323","19001759656"," 7005103523","9000588065",1,1,1,"");
        medidor3.save();

        Medidores medidor4= new Medidores(4,2,1,4,3,"1132","100710528","19001759657"," 7005103501","9000279789",1,1,1,"");
        medidor4.save();


        Medidores medidor5= new Medidores(5,1,1,5,3,"1132","643247123","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor5.save();

        Medidores medidor6= new Medidores(6,1,1,5,3,"1132","235443655","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor6.save();

        Medidores medidor7= new Medidores(7,3,1,5,3,"1132","432364775","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor7.save();

        Medidores medidor8= new Medidores(8,3,1,5,3,"1132","13254679","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor8.save();

        Medidores medidor9= new Medidores(9,4,1,5,3,"1132","43675878","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor9.save();

        Medidores medidor10= new Medidores(10,4,1,5,3,"1132","34646754","19001759554"," 7005103058","9002283754",1,1,1,"");
        medidor10.save();

    }

    private void setLector() {
        Lector lector= new Lector(1,"Z04","Eukaris","Arreaza","Bompart","",1,1,1,1);
        lector.save();

        sessionManager.setLector(lector);
    }

    private void setIndicadoresLectura() {

        IndicadoresLectura indicador1 = new IndicadoresLectura(1,1,2,1,"", 0, 548 /**LIMITE SUPERIOR*/,1962 /** LIMITE INFERIRO*/,
                245/**lim_super_va*/, 1659/** lim_infer_va*/,680.166666666667/** lectura_prevista */,
                "", 0d,0d,1,1);
        indicador1.save();

        IndicadoresLectura indicador2 = new IndicadoresLectura(2,2,1,2,"", 0, 32765, 33345,
                413, 993, 32903.8681318681, "", 0,0,1,1);
        indicador2.save();

        IndicadoresLectura indicador3 = new IndicadoresLectura(3,3,1,3,"",0,67943,68622,
                485,1164,68105.0824175824, "", 0,0,1,1);
        indicador3.save();

        IndicadoresLectura indicador4 = new IndicadoresLectura(4,4,1,4,"",0,396,1548,
                199,1351,504.104395604396,"",0,0,1,1);

        indicador4.save();



        IndicadoresLectura indicador5 = new IndicadoresLectura(5,5,2,1,"", 0, 548 /**LIMITE SUPERIOR*/,1962 /** LIMITE INFERIRO*/,
                245/**lim_super_va*/, 1659/** lim_infer_va*/,680.166666666667/** lectura_prevista */,
                "", 0d,0d,1,1);
        indicador5.save();

        IndicadoresLectura indicador6 = new IndicadoresLectura(6,6,1,2,"", 0, 32765, 33345,
                413, 993, 32903.8681318681, "", 0,0,1,1);
        indicador6.save();

        IndicadoresLectura indicador7 = new IndicadoresLectura(7,7,1,3,"",0,67943,68622,
                485,1164,68105.0824175824, "", 0,0,1,1);
        indicador7.save();

        IndicadoresLectura indicador8 = new IndicadoresLectura(8,8,1,4,"",0,396,1548,
                199,1351,504.104395604396,"",0,0,1,1);

        indicador8.save();

        IndicadoresLectura indicador9 = new IndicadoresLectura(9,9,2,1,"", 0, 548 /**LIMITE SUPERIOR*/,1962 /** LIMITE INFERIRO*/,
                245/**lim_super_va*/, 1659/** lim_infer_va*/,680.166666666667/** lectura_prevista */,
                "", 0d,0d,1,1);
        indicador9.save();

        IndicadoresLectura indicador10 = new IndicadoresLectura(10,10,1,2,"", 0, 32765, 33345,
                413, 993, 32903.8681318681, "", 0,0,1,1);
        indicador10.save();


    }

    private void setEstados() {
        Estados estados1= new Estados(1,"Amazonas","VE-X",1,1);
        estados1.save();

        Estados estados2= new Estados(2,"Anzoátegui","VE-B",1,1);
        estados2.save();

        Estados estados3= new Estados(3,"Apure","VE-C",1,1);
        estados3.save();

        Estados estados4= new Estados(4,"Aragua","VE-D",1,1);
        estados4.save();

        Estados estados5= new Estados(5,"Barinas","VE-E",1,1);
        estados5.save();

        Estados estados6= new Estados(6,"Bolívar","VE-F",1,1);
        estados6.save();

        Estados estados7= new Estados(7,"Carabobo","VE-G",1,1);
        estados7.save();

        Estados estados8= new Estados(8,"Cojedes","VE-H",1,1);
        estados8.save();

        Estados estados9= new Estados(9,"Delta Amacuro","VE-Y",1,1);
        estados9.save();

        Estados estados10= new Estados(10,"Falcón","VE-I",1,1);
        estados10.save();

        Estados estados11= new Estados(11,"Guárico","VE-J",1,1);
        estados11.save();

        Estados estados12= new Estados(12,"Lara","VE-K",1,1);
        estados12.save();

        Estados estados13= new Estados(13,"Mérida","VE-L",1,1);
        estados13.save();

        Estados estados14= new Estados(14,"Miranda","VE-M",1,1);
        estados14.save();

        Estados estados15= new Estados(15,"Monagas","VE-N",1,1);
        estados15.save();

        Estados estados16= new Estados(16,"Nueva Esparta","VE-O",1,1);
        estados16.save();

        Estados estados17= new Estados(17,"Portuguesa","VE-P",1,1);
        estados17.save();

        Estados estados18= new Estados(18,"Sucre","VE-R",1,1);
        estados18.save();

        Estados estados19= new Estados(19,"Táchira","VE-S",1,1);
        estados19.save();

        Estados estados20= new Estados(20,"Trujillo","VE-T",1,1);
        estados20.save();

        Estados estados21= new Estados(21,"Vargas","VE-W",1,1);
        estados21.save();

        Estados estados22= new Estados(22,"Yaracuy","VE-U",1,1);
        estados22.save();

        Estados estados23= new Estados(23,"Zulia","VE-V",1,1);
        estados23.save();

        Estados estados24= new Estados(24,"Distrito Capital","VE-A",1,1);
        estados24.save();

        Estados estados25= new Estados(25,"Dependencias Federales","VE-Z",1,1);
        estados25.save();
    }

    private void setCentroLectura() {
        CentroLectura centroLectura= new CentroLectura(1, "001", "EL HATILLITO ABAJO", 1, 1, 231);
        centroLectura.save();
    }

    private void setCalleRuta() {
        CalleAvenida calleAvenida1= new CalleAvenida(1,"LA UNION",1,"", 1, 1, 622,"CORRALITO CURUJULES", 914835);
        calleAvenida1.save();

        CalleAvenida calleAvenida2= new CalleAvenida(2,"SUBIDA DE ORIPOTO",1,"",1,1,622,"ORIPOTO",905646);
        calleAvenida2.save();
    }

    private void setFRuta() {
        FRuta fRuta1= new FRuta(1,"01","LIBERADA",1,1,"La ruta fué programada y puesta disponible por el sistema SAP-CCS y ya puede ser utilizada por el Gestor SIMLEC");
        fRuta1.save();

        FRuta fRuta2= new FRuta(2,"02","ASIGNADA",1,1,"La programación de la ruta fue asignada a un lector y un dispositivo móvil para un período determinado ");
        fRuta2.save();

        FRuta fRuta3= new FRuta(3,"03","CARGADA",1,1,"La programación de la ruta fue transferida al dispositivo móvil asignado para el inicio del recorrido de lectura");
        fRuta3.save();

        FRuta fRuta4= new FRuta(4,"04","DESCARGADA",1,1,"Los índices de lectura tomados en el recorrido programado para la ruta en el período determinado ya fue transferido al gestor de lectura Web");
        fRuta4.save();

        FRuta fRuta5= new FRuta(5,"05","VALIDADA",1,1,"Los índices de lectura tomados para una ruta fueron verificados y ajustados por el supervisor del centro de lectura");
        fRuta5.save();

        FRuta fRuta6= new FRuta(6,"06","PROCESADA",1,1,"La información de los índices de lectura y sus eventos fueron actualizados al sistema SAP-CCS por el supervisor del centro de lectura");
        fRuta6.save();

    }

    public void setFNotasLectura() {

        FNotaLectura fNotaLectura1= new FNotaLectura(1, "01", "Imposibilidad de Accesar a Objeto de Conexión", "Imposibilidad para acceder a un inmueble o Identificación comprendido por uno o varios puntos de suministros a fin de tomar la lectura.", 1, 1, 1, 3, "Estimará ");
        fNotaLectura1.save();

        FNotaLectura fNotaLectura2= new FNotaLectura(2,"02","Imposibilidad Accesar a Ubicación de Aparato","Imposibilidad para accesar al lugar donde están ubicados los medidores dentro de un inmueble o edificación.",1,1,1,3,"Estimará ");
        fNotaLectura2.save();

        FNotaLectura fNotaLectura3= new FNotaLectura(3,"03","Posible Irregularidad en Medidor","Cuando el lector visualiza posible alteración al equipo de medición y sus accesorios, produciendo el incorrecto registro de los consumos de energía y demanda. (Imanes, Radiografías, Medidores Volteados, Acometidas Perforadas)",2,1,1,1,"El lector deberá registrar el índice que reporta el medidor y está generará un aviso tipo S2 a la Unidad Protección de Ventas ");
        fNotaLectura3.save();

        FNotaLectura fNotaLectura4= new FNotaLectura(4,"04","Medidor Averiado","Cuando el lector visualiza que el Medidor se encuentra con golpes, vidrio roto, quemado, perforado, etc. y que pueden originar que no se registran los consumos y demandas correctamente.",2,1,1,1,"El lector deberá registrar el índice que reporta el medidor y está generará un aviso tipo S2 a la Unidad de Inspección y Reclamos y Anomalías");
        fNotaLectura4.save();

        FNotaLectura fNotaLectura5= new FNotaLectura(5,"05","Medidor no Encontrado","Es cuando el lector no ubica el aparato en la dirección indicada en Tpl y exista evidencia de retiro, hurto o cambio de medidor para lo cual deberán colocar el medidor sobrante  etc.",2,1,1,2,"Genera Inverosímil");
        fNotaLectura5.save();

        FNotaLectura fNotaLectura6= new FNotaLectura(6,"06","Medidor mal Ubicado","Son aquellos medidores que están instalado en condiciones fuera de norma donde se imposibilite la lectura: Muy alto, Muy Bajo, entre transformadores, cerca de barras de alta tensión etc.",2,1,1,3,"El lector deberá reportar el índice y la demanda  si no representa riesgo. Esto generará una orden SM01 a la Unidad de Instalación.");
        fNotaLectura6.save();

        FNotaLectura fNotaLectura7= new FNotaLectura(7,"07","Número de Serie Borrado","Cuando el número de medidor no se visualiza",2,1,1,2,"Genera Orden SM01 a la Unidad de Instalaciones");
        fNotaLectura7.save();

        FNotaLectura fNotaLectura8= new FNotaLectura(8,"08","Medidor Registro Inverso","Cuando se visualiza que la relojería y el disco del medidor giran en sentido inverso",2,1,1,1,"El lector deberá reportar el índice y esto generará un Aviso S2 a Inspecciones Reclamos y Anomalías.");
        fNotaLectura8.save();

        FNotaLectura fNotaLectura9= new FNotaLectura(9,"09","Imposible Lectura Medidor","Cuando el lector a podido llegar al sector o al objeto de conexión y se le ha imposibilitado la toma de la lectura por manifestaciones en la zona,  disturbios, invadidos, obstáculos en los módulos, Módulos llenos de agua, abejas, roedores, altos riesgos. ",2,1,1,1,"Estimará. Es importante destacar que muchas de las causas antes mencionadas pueden tener relación con otras notas de lectura pero se utilizará cuando no se logre tomar la lectura del medidor.");
        fNotaLectura9.save();

        FNotaLectura fNotaLectura10= new FNotaLectura(10,"10","Leído por el Cliente","Lectura suministrada por el usuario",2,1,1,3,"El lector reporta el índice");
        fNotaLectura10.save();

        FNotaLectura fNotaLectura11= new FNotaLectura(11,"11","Cerradura/Candado Dañado","Cuando el Lector Identifica que el módulo o puertas donde se encuentran los aparatos tienen cerradura particular o  tienen candados dañados o no lo tienen. Se debe indicar un solo aparato de referencia.",2,1,1,2,"Genera un Aviso S2 a Inspecciones, Reclamos y Anomalías.");
        fNotaLectura11.save();

        FNotaLectura fNotaLectura12= new FNotaLectura(12,"12","Liberado por Responsable","Solo para ser Usado por responsable del centro de Lectura (puede ser usado para estimar una unidad de lectura cuando no puede realizarse)",2,1,1,3,"Estimará");
        fNotaLectura12.save();

        FNotaLectura fNotaLectura13= new FNotaLectura(13,"13","Casa Cerrada ","Cuando el Lector a ubicado la dirección pero el medidor esta dentro de la casa y no puede tomar la lectura",2,1,1,3,"Estimará");
        fNotaLectura13.save();

        FNotaLectura fNotaLectura14= new FNotaLectura(14,"14","Decreto 46 ","Cuando el lector identifica que el módulo esta en remodelación y los aparatos están desmantelados en conexión directa. No se toma índice ",1,1,1,1,"Estimará");
        fNotaLectura14.save();

        FNotaLectura fNotaLectura15= new FNotaLectura(15,"15","Aparato Apagado","Aparatos electrónicos que al momento de tomar la lectura, el mismo no posee información en el Display.",2,1,1,1,"El responsable del centro de lectura deberá verificar si el medidor esta cortado, si no esta deberá pasar a la unidad Protección de Venta");
        fNotaLectura15.save();

        FNotaLectura fNotaLectura16= new FNotaLectura(16,"16","Conexión Directa","Cuando el lector visualiza que la acometida no pasa por el medidor o esta intervenida o puenteada.",2,1,1,1,"El lector deberá reportar índice y generará orden a  la Unidad Protección de Venta.");
        fNotaLectura16.save();

        FNotaLectura fNotaLectura17= new FNotaLectura(17,"17","Punto de Medida sin Higiene y Seguridad","Cuando el lector visualiza que las condiciones de Seguridad e Higiene no están dadas. (Filtraciones, Inundaciones, Roedores, Iluminación).",1,1,1,2,"El lector deberá traer lectura, en caso de imposibilidad deberá utilizar nota respectiva a nivel de aparato.");
        fNotaLectura17.save();

        FNotaLectura fNotaLectura18= new FNotaLectura(18,"18","Dirección Errada","Cuando el lector ubica el aparato pero la dirección no coincide con la que debería ser.",2,1,1,3,"El lector deberá traer lectura, y generará aviso a Data Técnica.");
        fNotaLectura18.save();

        FNotaLectura fNotaLectura19= new FNotaLectura(19,"19","Objeto de Conexión Invadido","Cuando el lector comprueba que un inmueble esta invadido y toma lectura.",1,1,1,2,"El lector deberá traer lectura, en caso de imposibilidad deberá utilizar nota respectiva a nivel de aparato. ");
        fNotaLectura19.save();

        FNotaLectura fNotaLectura20= new FNotaLectura(20,"20","Medidor sin tapa Cubre Borne","Cuando el lector visualiza que el aparato no posee la misma",2,1,1,1,"El lector deberá reportar índice y generará orden a  la Unidad Protección de Venta.");
        fNotaLectura20.save();

        FNotaLectura fNotaLectura21= new FNotaLectura(21,"21","Antisociales en la Zona","Cuando el lector no le permiten tomar lectura por causa de inseguridad",1,1,1,3,"Estimación");
        fNotaLectura21.save();

        FNotaLectura fNotaLectura22= new FNotaLectura(22,"22","Punto de Medida fuera de norma","Cuando el lector visualiza punto de medida no cumple con la normativa.",2,1,1,1,"Estimación");
        fNotaLectura22.save();

        FNotaLectura fNotaLectura23= new FNotaLectura(23,"60","Generar Aviso S2 Inspección Inst.Desconectad","Inverosímil, generado por estado de instalación bloqueada",2,1,1,1,"Analista genera Aviso S2 para Inspección de Punto de Suministro");
        fNotaLectura23.save();

        FNotaLectura fNotaLectura24= new FNotaLectura(24,"61","Generar Aviso S2 Inspección por Bajo Consumo","Se genera por la disminución de un 35% del consumo calculado en base al histórico de los últimos seis (6) meses",2,1,1,1,"Analista genera Aviso S2 para Inspección de Punto de Suministro");
        fNotaLectura24.save();

        FNotaLectura fNotaLectura25= new FNotaLectura(25,"62","Inspección Inst. de Baja con Cons","Son medidores que mantienen consumo y no tienen contrato, estos Casos no facturan, pero se leen mensualmente(ESTADO 05).",2,1,1,1,"Analista genera Aviso S2 para Inspección de Punto de Suministro");
        fNotaLectura25.save();
    }
}
