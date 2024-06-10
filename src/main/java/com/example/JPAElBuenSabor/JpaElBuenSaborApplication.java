package com.example.JPAElBuenSabor;

import com.example.JPAElBuenSabor.entities.*;
import com.example.JPAElBuenSabor.entities.enums.Rol;
import com.example.JPAElBuenSabor.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class JpaElBuenSaborApplication{

	private static final Logger logger = LoggerFactory.getLogger(JpaElBuenSaborApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;

	@Autowired
	private HistoricoPrecioPromocionRepository historicoPrecioPromocionRepository;

	@Autowired
	private HistoricoRolRepository historicoRolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	HistoricoStockRepository historicoStockRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private HistoricoHorarioRepository historicoHorarioRepository;

	@Autowired
	private HorarioCierreRepository horarioCierreRepository;

	@Autowired
	HistoricoPrecioArticuloInsumoRepository historicoPrecioArticuloInsumoRepository;

	@Autowired
	private HorarioAperturaRepository horarioAperturaRepository;

	@Autowired
	private DomicilioClienteRepository domicilioClienteRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private TelefonoRepository telefonoRepository;

	@Autowired
	HorarioPromocionAperturaRepository horarioPromocionAperturaRepository;

	@Autowired
	HorarioPromocionCierreRepository horarioPromocionCierreRepository;

	@Autowired
	HistoricoHorarioPromocionRepository historicoHorarioPromocionRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaSucursalRepository categoriaSucursalRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private PromocionRepository promocionRepository;
	@Autowired
	private PromocionSucursalRepository promocionSucursalRepository;

	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
/*
	@Autowired
	private PedidoRepository pedidoRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(JpaElBuenSaborApplication.class, args);
	}


	@Bean
	CommandLineRunner init() {
		return args -> {

			Calendar calendar=Calendar.getInstance();

			Pais pais1 = Pais.builder().denominacion("Argentina").build();
			paisRepository.save(pais1);

			//CREACION DE PROVINCIAS
			Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais1).build();
			Provincia provincia2 = Provincia.builder().nombre("Buenos Aires").pais(pais1).build();

			provinciaRepository.save(provincia1);
			provinciaRepository.save(provincia2);
			//CREACION DE LOCALIDADES

			Localidad localidad1 = Localidad.builder().nombre("Lujan de Cuyo").provincia(provincia1).build();
			Localidad localidad2 = Localidad.builder().nombre("Guaymallen").provincia(provincia1).build();
			Localidad localidad3 = Localidad.builder().nombre("Mar del Plata").provincia(provincia2).build();
			Localidad localidad4 = Localidad.builder().nombre("Mar de las Pampas").provincia(provincia2).build();

			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);
			localidadRepository.save(localidad3);
			localidadRepository.save(localidad4);

			//CREACION DE DOMICILIOS
			Domicilio domicilio1=Domicilio.builder()
					.cp(5511)
					.calle("Avenida siempre viva")
					.numero(21)
					.localidad(localidad1)
					.build();
			Domicilio domicilio2=Domicilio.builder()
					.cp(5522)
					.calle("Calle Jon")
					.numero(2133)
					.localidad(localidad1)
					.build();
			Domicilio domicilio3=Domicilio.builder()
					.cp(5533)
					.calle("Calle victoria")
					.numero(221)
					.localidad(localidad2)
					.build();
			Domicilio domicilio4=Domicilio.builder()
					.cp(1233)
					.calle("Calle Chaco")
					.numero(1231)
					.localidad(localidad2)
					.build();
			Domicilio domicilio5=Domicilio.builder()
					.cp(5555)
					.calle("Calle Junin")
					.numero(55)
					.localidad(localidad2)
					.build();
			Domicilio domicilio6=Domicilio.builder()
					.cp(55)
					.calle("Calle Salta")
					.numero(11)
					.localidad(localidad3)
					.build();
			Domicilio domicilio7=Domicilio.builder()
					.cp(55133)
					.calle("Calle San Juan")
					.numero(2221)
					.localidad(localidad4)
					.build();

			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);
			domicilioRepository.save(domicilio4);
			domicilioRepository.save(domicilio5);
			domicilioRepository.save(domicilio6);
			domicilioRepository.save(domicilio7);

			//creacioN empresa
			Empresa empresa =Empresa.builder()
					.cuil("20385462511")
					.nombre("Empresa de prueba")
					.razonSocial("Razon muy social").build();
			empresaRepository.save(empresa);
			//CREACION DE Sucursal

			Sucursal sucursal1 = Sucursal.builder()
					.nombre("Arcor")
					.domicilio(domicilio1)
					.esCasaMatriz(false)
					.empresa(empresa)
					.build();
			Sucursal sucursal2 = Sucursal.builder()
					.nombre("TiendaNube")
					.domicilio(domicilio2)
					.esCasaMatriz(true)
					.empresa(empresa)
					.build();
			Sucursal sucursal3 = Sucursal.builder()
					.nombre("Adidas")
					.domicilio(domicilio7)
					.esCasaMatriz(false)
					.empresa(empresa)
					.build();
			sucursalRepository.save(sucursal1);
			sucursalRepository.save(sucursal2);
			sucursalRepository.save(sucursal3);

			Imagen imagen1=Imagen.builder()
					.denominacion("https://www.imagen1.com").build();
			Imagen imagen2=Imagen.builder()
					.denominacion("https://www.imagen2.com").build();
			Imagen imagen3=Imagen.builder()
					.denominacion("https://www.imagen3.com").build();
			Imagen imagen4=Imagen.builder()
					.denominacion("https://www.imagen4.com").build();
			Imagen imagen5=Imagen.builder()
					.denominacion("https://www.imagen5.com").build();
			Imagen imagen6=Imagen.builder()
					.denominacion("https://www.imagen6.com").build();

			imagenRepository.save(imagen1);
			imagenRepository.save(imagen2);
			imagenRepository.save(imagen3);
			imagenRepository.save(imagen5);
			imagenRepository.save(imagen4);
			imagenRepository.save(imagen6);


			HorarioCierre horarioCierre1=HorarioCierre.builder()
					.hora(21)
					.minuto(00)
					.build();
			HorarioCierre horarioCierre2=HorarioCierre.builder()
					.hora(22)
					.minuto(30)
					.build();
			HorarioCierre horarioCierre3=HorarioCierre.builder()
					.hora(23)
					.minuto(00)
					.build();

			HorarioApertura horarioApertura1=HorarioApertura.builder()
					.hora(18)
					.minuto(00)
					.build();
			HorarioApertura horarioApertura2=HorarioApertura.builder()
					.hora(17)
					.minuto(00)
					.build();
			HorarioApertura horarioApertura3=HorarioApertura.builder()
					.hora(19)
					.minuto(00)
					.build();
			horarioAperturaRepository.save(horarioApertura3);
			horarioAperturaRepository.save(horarioApertura2);
			horarioAperturaRepository.save(horarioApertura1);

			horarioCierreRepository.save(horarioCierre1);
			horarioCierreRepository.save(horarioCierre2);
			horarioCierreRepository.save(horarioCierre3);

			HistoricoHorario historicoHorario1= HistoricoHorario.builder()
					.sucursal(sucursal1)
					.fecha(new Date())
					.horarioApertura(horarioApertura1)
					.horarioCierre(horarioCierre1)
					.build();

			HistoricoHorario historicoHorario2= HistoricoHorario.builder()
					.sucursal(sucursal1)
					.fecha(new Date())
					.horarioApertura(horarioApertura2)
					.horarioCierre(horarioCierre2)
					.build();
			HistoricoHorario historicoHorario3= HistoricoHorario.builder()
					.sucursal(sucursal1)
					.fecha(new Date())
					.horarioApertura(horarioApertura3)
					.horarioCierre(horarioCierre3)
					.build();

			historicoHorarioRepository.save(historicoHorario3);
			historicoHorarioRepository.save(historicoHorario1);
			historicoHorarioRepository.save(historicoHorario2);

			Usuario usuario1=Usuario.builder().userName("Terminator").contrasena("1234").build();
			Usuario usuario2=Usuario.builder().userName("Iron-Man").contrasena("12345").build();
			Usuario usuario3=Usuario.builder().userName("Spiderman").contrasena("123456").build();
			Usuario usuario4=Usuario.builder().userName("Thor").contrasena("1234567").build();
			Usuario usuario5=Usuario.builder().userName("Hulk").contrasena("12345678").build();
			Usuario usuario6=Usuario.builder().userName("Thanos").contrasena("123456789").build();

			usuarioRepository.save(usuario1);
			usuarioRepository.save(usuario2);
			usuarioRepository.save(usuario3);
			usuarioRepository.save(usuario4);
			usuarioRepository.save(usuario5);
			usuarioRepository.save(usuario6);


			Cliente cliente1=Cliente.builder()
					.nombre("Carlitox")
					.fechaNacimiento(new Date())
					.apellido("Finster")
					.imagen(imagen2)
					.usuario(usuario1)
					.build();
			Cliente cliente2=Cliente.builder()
					.nombre("Carlos")
					.fechaNacimiento(new Date())
					.apellido("Rodriguez")
					.imagen(imagen6)
					.usuario(usuario5)
					.build();
			Cliente cliente3=Cliente.builder()
					.nombre("Gerardo")
					.apellido("Magni")
					.usuario(usuario3)
					.imagen(imagen1)
					.fechaNacimiento(new Date())
					.build();

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			clienteRepository.save(cliente3);

			DomicilioCliente domicilioCliente1=DomicilioCliente.builder()
					.domicilio(domicilio1)
					.estaActivo(true)
					.nombre("Casa Abuela")
					.cliente(cliente1)
					.build();
			DomicilioCliente domicilioCliente2=DomicilioCliente.builder()
					.domicilio(domicilio2)
					.estaActivo(true)
					.nombre("Casa Novia")
					.cliente(cliente1)
					.build();

			DomicilioCliente domicilioCliente3=DomicilioCliente.builder()
					.domicilio(domicilio3)
					.estaActivo(true)
					.nombre("Casa Novia 2")
					.cliente(cliente1)
					.build();

			domicilioClienteRepository.save(domicilioCliente1);
			domicilioClienteRepository.save(domicilioCliente2);
			domicilioClienteRepository.save(domicilioCliente3);

			Empleado empleado1=Empleado.builder()
					.legajo("123")
					.sucursal(sucursal1)
					.apellido("Vargas")
					.usuario(usuario4)
					.nombre("Pedro")
					.imagen(imagen5)
					.fechaNacimiento(new Date())
					.build();
			Empleado empleado2=Empleado.builder()
					.legajo("1123")
					.apellido("Villavicencio")
					.nombre("Pablo")
					.usuario(usuario2)
					.imagen(imagen4)
					.fechaNacimiento(new Date())
					.sucursal(sucursal1).build();
			Empleado empleado3=Empleado.builder()
					.legajo("1223")
					.apellido("Vidal")
					.usuario(usuario6)
					.imagen(imagen5)
					.nombre("Gabriela")
					.fechaNacimiento(new Date())
					.sucursal(sucursal3).build();

			empleadoRepository.save(empleado1);
			empleadoRepository.save(empleado2);
			empleadoRepository.save(empleado3);

			Email email1=Email.builder().correo("pepe1@gmail.com").persona(cliente1).build();
			Email email2=Email.builder().correo("pepe2@gmail.com").persona(cliente3).build();
			Email email3=Email.builder().correo("pepe3@gmail.com").persona(cliente3).build();
			Email email4=Email.builder().correo("pepe4@gmail.com").persona(cliente2).build();
			Email email5=Email.builder().correo("pepe5@gmail.com").persona(empleado2).build();
			Email email6=Email.builder().correo("pepe6@gmail.com").persona(empleado2).build();
			Email email7=Email.builder().correo("pepe7@gmail.com").persona(empleado3).build();
			Email email8=Email.builder().correo("pepe8@gmail.com").persona(empleado1).build();
			Email email9=Email.builder().correo("pepe9@gmail.com").persona(empleado1).build();

			emailRepository.save(email1);
			emailRepository.save(email2);
			emailRepository.save(email3);
			emailRepository.save(email4);
			emailRepository.save(email5);
			emailRepository.save(email6);
			emailRepository.save(email7);
			emailRepository.save(email8);
			emailRepository.save(email9);

			Telefono telefono1=Telefono.builder().numero("4813129").persona(cliente1).build();
			Telefono telefono2=Telefono.builder().numero("4813129").persona(empleado3).build();
			Telefono telefono3=Telefono.builder().numero("4813129").persona(cliente3).build();
			Telefono telefono4=Telefono.builder().numero("4813129").persona(cliente3).build();
			Telefono telefono5=Telefono.builder().numero("4813129").persona(empleado2).build();

			telefonoRepository.save(telefono1);
			telefonoRepository.save(telefono2);
			telefonoRepository.save(telefono3);
			telefonoRepository.save(telefono4);
			telefonoRepository.save(telefono5);

			HistoricoRol historicoRol1=HistoricoRol.builder().fecha(new Date()).persona(cliente1).rol(Rol.DELIVERY).build();
			HistoricoRol historicoRol2=HistoricoRol.builder().fecha(new Date()).persona(cliente2).rol(Rol.CLIENTE).build();
			HistoricoRol historicoRol3=HistoricoRol.builder().fecha(new Date()).persona(cliente3).rol(Rol.CLIENTE).build();
			HistoricoRol historicoRol4=HistoricoRol.builder().fecha(new Date()).persona(empleado3).rol(Rol.COCINERO).build();
			HistoricoRol historicoRol5=HistoricoRol.builder().fecha(new Date()).persona(empleado1).rol(Rol.ADMIN).build();
			HistoricoRol historicoRol6=HistoricoRol.builder().fecha(new Date()).persona(empleado2).rol(Rol.CAJERO).build();
			HistoricoRol historicoRol7=HistoricoRol.builder().fecha(new Date()).persona(cliente1).rol(Rol.CLIENTE).build();

			historicoRolRepository.save(historicoRol1);
			historicoRolRepository.save(historicoRol2);
			historicoRolRepository.save(historicoRol3);
			historicoRolRepository.save(historicoRol4);
			historicoRolRepository.save(historicoRol5);
			historicoRolRepository.save(historicoRol6);
			historicoRolRepository.save(historicoRol7);

			Promocion promo1=Promocion.builder()
					.imagen(imagen3)
					.denominacion("Dia de los enamorados")
					.descripcion("Menu especial para 2 personas")
					.fechaDesde(new Date())
					.fechaHasta(new Date())
					.build();
			Promocion promo2=Promocion.builder()
					.imagen(imagen3)
					.denominacion("Dia del niño")
					.descripcion("Menu infantil a mitad de precio")
					.fechaDesde(new Date())
					.fechaHasta(new Date())
					.build();
			Promocion promo3=Promocion.builder()
					.imagen(imagen3)
					.denominacion("Dia de la madre")
					.descripcion("Si venis con tu madre, paga mitad de precio")
					.fechaDesde(new Date())
					.fechaHasta(new Date())
					.build();

			promocionRepository.save(promo1);
			promocionRepository.save(promo2);
			promocionRepository.save(promo3);

			HistoricoPrecioPromocion historicoPrecioPromocion1=HistoricoPrecioPromocion.builder()
					.promocion(promo1)
					.fecha(new Date())
					.precioPromocional(70.5).build();
			HistoricoPrecioPromocion historicoPrecioPromocion2=HistoricoPrecioPromocion.builder()
					.promocion(promo3)
					.fecha(new Date())
					.precioPromocional(20.52).build();
			HistoricoPrecioPromocion historicoPrecioPromocion3=HistoricoPrecioPromocion.builder()
					.promocion(promo2)
					.fecha(new Date())
					.precioPromocional(77.5).build();
			calendar.set(2022,11,18);
			HistoricoPrecioPromocion historicoPrecioPromocion4=HistoricoPrecioPromocion.builder()
					.promocion(promo1)
					.fecha(calendar.getTime())
					.precioPromocional(90.5).build();

			historicoPrecioPromocionRepository.save(historicoPrecioPromocion1);
			historicoPrecioPromocionRepository.save(historicoPrecioPromocion2);
			historicoPrecioPromocionRepository.save(historicoPrecioPromocion3);
			historicoPrecioPromocionRepository.save(historicoPrecioPromocion4);

			PromocionSucursal promocionSucursal1=PromocionSucursal.builder()
					.promocion(promo1)
					.estaActivo(true)
					.sucursal(sucursal1)
					.build();
			PromocionSucursal promocionSucursal2=PromocionSucursal.builder()
					.promocion(promo1)
					.estaActivo(true)
					.sucursal(sucursal2)
					.build();
			PromocionSucursal promocionSucursal3=PromocionSucursal.builder()
					.promocion(promo2)
					.estaActivo(true)
					.sucursal(sucursal2)
					.build();
			PromocionSucursal promocionSucursal4=PromocionSucursal.builder()
					.promocion(promo1)
					.estaActivo(true)
					.sucursal(sucursal3)
					.build();
			PromocionSucursal promocionSucursal5=PromocionSucursal.builder()
					.promocion(promo3)
					.estaActivo(true)
					.sucursal(sucursal1)
					.build();

			promocionSucursalRepository.save(promocionSucursal1);
			promocionSucursalRepository.save(promocionSucursal4);
			promocionSucursalRepository.save(promocionSucursal5);
			promocionSucursalRepository.save(promocionSucursal3);
			promocionSucursalRepository.save(promocionSucursal2);

			HorarioPromocionApertura horarioPromocionApertura1=HorarioPromocionApertura.builder().hora(20).minuto(00).build();
			HorarioPromocionApertura horarioPromocionApertura2=HorarioPromocionApertura.builder().hora(21).minuto(00).build();
			HorarioPromocionApertura horarioPromocionApertura3=HorarioPromocionApertura.builder().hora(22).minuto(00).build();
			HorarioPromocionCierre horarioPromocionCierre1=HorarioPromocionCierre.builder().hora(22).minuto(00).build();
			HorarioPromocionCierre horarioPromocionCierre2=HorarioPromocionCierre.builder().hora(23).minuto(00).build();
			HorarioPromocionCierre horarioPromocionCierre3=HorarioPromocionCierre.builder().hora(24).minuto(00).build();

			horarioPromocionAperturaRepository.save(horarioPromocionApertura3);
			horarioPromocionAperturaRepository.save(horarioPromocionApertura2);
			horarioPromocionAperturaRepository.save(horarioPromocionApertura1);
			horarioPromocionCierreRepository.save(horarioPromocionCierre1);
			horarioPromocionCierreRepository.save(horarioPromocionCierre2);
			horarioPromocionCierreRepository.save(horarioPromocionCierre3);

			HistoricoHorarioPromocion historicoHorarioPromocion1=HistoricoHorarioPromocion.builder()
					.horarioPromocionApertura(horarioPromocionApertura1)
					.horarioPromocionCierre(horarioPromocionCierre1)
					.fecha(new Date())
					.promocion(promo1)
					.build();
			HistoricoHorarioPromocion historicoHorarioPromocion2=HistoricoHorarioPromocion.builder()
					.horarioPromocionApertura(horarioPromocionApertura2)
					.horarioPromocionCierre(horarioPromocionCierre2)
					.fecha(new Date())
					.promocion(promo2)
					.build();
			HistoricoHorarioPromocion historicoHorarioPromocion3=HistoricoHorarioPromocion.builder()
					.horarioPromocionApertura(horarioPromocionApertura3)
					.horarioPromocionCierre(horarioPromocionCierre3)
					.fecha(new Date())
					.promocion(promo3)
					.build();
			HistoricoHorarioPromocion historicoHorarioPromocion4=HistoricoHorarioPromocion.builder()
					.horarioPromocionApertura(horarioPromocionApertura1)
					.horarioPromocionCierre(horarioPromocionCierre3)
					.fecha(new Date())
					.promocion(promo1)
					.build();

			historicoHorarioPromocionRepository.save(historicoHorarioPromocion1);
			historicoHorarioPromocionRepository.save(historicoHorarioPromocion2);
			historicoHorarioPromocionRepository.save(historicoHorarioPromocion4);
			historicoHorarioPromocionRepository.save(historicoHorarioPromocion3);

			Categoria categoria1=Categoria.builder()
					.denominacion("CategoriaRoot")
					.esInsumo(false)
					.build();
			Categoria categoria2=Categoria.builder()
					.denominacion("Carnes")
					.esInsumo(true)
					.categoria(categoria1)
					.build();
			Categoria categoria3=Categoria.builder()
					.denominacion("Bebidas")
					.esInsumo(false)
					.categoria(categoria1)
					.build();
			Categoria categoria4=Categoria.builder()
					.denominacion("Pizzas")
					.esInsumo(false)
					.categoria(categoria1)
					.build();
			Categoria categoria5=Categoria.builder()
					.denominacion("Gaseosas")
					.esInsumo(false)
					.categoria(categoria3)
					.build();
			Categoria categoria6=Categoria.builder()
					.denominacion("Cervezas")
					.esInsumo(true)
					.categoria(categoria3)
					.build();
			Categoria categoria7=Categoria.builder()
					.denominacion("Verduras")
					.esInsumo(true)
					.categoria(categoria1)
					.build();
			Categoria categoria8=Categoria.builder()
					.denominacion("Lacteos")
					.esInsumo(true)
					.categoria(categoria1)
					.build();
			Categoria categoria9=Categoria.builder()
					.denominacion("Quesos")
					.esInsumo(true)
					.categoria(categoria8)
					.build();
			Categoria categoria10=Categoria.builder()
					.denominacion("Insumos")
					.esInsumo(true)
					.categoria(categoria1)
					.build();
			Categoria categoria11=Categoria.builder()
					.denominacion("Condimentos")
					.esInsumo(true)
					.categoria(categoria1)
					.build();
			Categoria categoria12=Categoria.builder()
					.denominacion("Panificados")
					.esInsumo(true)
					.categoria(categoria1)
					.build();

			categoriaRepository.save(categoria1);
			categoriaRepository.save(categoria2);
			categoriaRepository.save(categoria3);
			categoriaRepository.save(categoria4);
			categoriaRepository.save(categoria5);
			categoriaRepository.save(categoria6);
			categoriaRepository.save(categoria7);
			categoriaRepository.save(categoria8);
			categoriaRepository.save(categoria9);
			categoriaRepository.save(categoria10);
			categoriaRepository.save(categoria11);
			categoriaRepository.save(categoria12);

			CategoriaSucursal categoriaSucursal1=CategoriaSucursal.builder()
					.categoria(categoria2)
					.sucursal(sucursal1)
					.estaActivo(true)
					.build();
			CategoriaSucursal categoriaSucursal2=CategoriaSucursal.builder()
					.categoria(categoria3)
					.sucursal(sucursal1)
					.estaActivo(true)
					.build();
			CategoriaSucursal categoriaSucursal3=CategoriaSucursal.builder()
					.categoria(categoria4)
					.sucursal(sucursal1)
					.estaActivo(false)
					.build();
			CategoriaSucursal categoriaSucursal4=CategoriaSucursal.builder()
					.categoria(categoria5)
					.sucursal(sucursal1)
					.estaActivo(true)
					.build();
			CategoriaSucursal categoriaSucursal5=CategoriaSucursal.builder()
					.categoria(categoria6)
					.sucursal(sucursal1)
					.estaActivo(true)
					.build();
			CategoriaSucursal categoriaSucursal6=CategoriaSucursal.builder()
					.categoria(categoria2)
					.sucursal(sucursal2)
					.estaActivo(true)
					.build();
			CategoriaSucursal categoriaSucursal7=CategoriaSucursal.builder()
					.categoria(categoria3)
					.sucursal(sucursal2)
					.estaActivo(true)
					.build();

			categoriaSucursalRepository.save(categoriaSucursal6);
			categoriaSucursalRepository.save(categoriaSucursal5);
			categoriaSucursalRepository.save(categoriaSucursal4);
			categoriaSucursalRepository.save(categoriaSucursal3);
			categoriaSucursalRepository.save(categoriaSucursal2);
			categoriaSucursalRepository.save(categoriaSucursal1);
			categoriaSucursalRepository.save(categoriaSucursal7);

			UnidadMedida unidadMedida1=UnidadMedida.builder()
					.denominacion("gramos")
					.build();
			UnidadMedida unidadMedida2=UnidadMedida.builder()
					.denominacion("litros")
					.build();
			UnidadMedida unidadMedida3=UnidadMedida.builder()
					.denominacion("cucharadita")
					.build();
			UnidadMedida unidadMedida4=UnidadMedida.builder()
					.denominacion("porciones")
					.build();
			UnidadMedida unidadMedida5=UnidadMedida.builder()
					.denominacion("unidades")
					.build();
			unidadMedidaRepository.save(unidadMedida1);
			unidadMedidaRepository.save(unidadMedida2);
			unidadMedidaRepository.save(unidadMedida3);
			unidadMedidaRepository.save(unidadMedida4);
			unidadMedidaRepository.save(unidadMedida5);

			ArticuloInsumo articuloInsumo1=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Tomate")
					.stockMaximo(50)
					.stockMinimo(10)
					.categoria(categoria7)
					.unidadMedida(unidadMedida5)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo2=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Harina")
					.stockMaximo(10000)
					.stockMinimo(1000)
					.categoria(categoria10)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo3=ArticuloInsumo.builder()
					.esParaElaborar(false)
					.denominacion("Coca Cola 1.25")
					.stockMaximo(500)
					.stockMinimo(100)
					.categoria(categoria5)
					.unidadMedida(unidadMedida2)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo4=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Muzzarela")
					.stockMaximo(50000)
					.stockMinimo(10000)
					.categoria(categoria9)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo5=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Lechuga")
					.stockMaximo(50000)
					.stockMinimo(1000)
					.categoria(categoria7)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo6=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Mayonesa")
					.stockMaximo(500000)
					.stockMinimo(100000)
					.categoria(categoria11)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo7=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Ketchup")
					.stockMaximo(500000)
					.stockMinimo(100000)
					.categoria(categoria11)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo8=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Carne Molida")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria2)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo9=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Lomo")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria2)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo10=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Pan de Hamburguesa")
					.stockMaximo(50000)
					.stockMinimo(10000)
					.categoria(categoria12)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo11=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Pan Arabe para Lomo")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria12)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo12=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Huevo")
					.stockMaximo(50000)
					.stockMinimo(10000)
					.categoria(categoria10)
					.unidadMedida(unidadMedida5)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo13=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Jamon")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria10)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo14=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Sal")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria10)
					.unidadMedida(unidadMedida3)
					.imagen(imagen6)
					.build();
			ArticuloInsumo articuloInsumo15=ArticuloInsumo.builder()
					.esParaElaborar(true)
					.denominacion("Papa")
					.stockMaximo(500000)
					.stockMinimo(10000)
					.categoria(categoria7)
					.unidadMedida(unidadMedida1)
					.imagen(imagen6)
					.build();

			articuloInsumoRepository.save(articuloInsumo1);
			articuloInsumoRepository.save(articuloInsumo2);
			articuloInsumoRepository.save(articuloInsumo3);
			articuloInsumoRepository.save(articuloInsumo4);
			articuloInsumoRepository.save(articuloInsumo5);
			articuloInsumoRepository.save(articuloInsumo6);
			articuloInsumoRepository.save(articuloInsumo7);
			articuloInsumoRepository.save(articuloInsumo8);
			articuloInsumoRepository.save(articuloInsumo9);
			articuloInsumoRepository.save(articuloInsumo10);
			articuloInsumoRepository.save(articuloInsumo11);
			articuloInsumoRepository.save(articuloInsumo12);
			articuloInsumoRepository.save(articuloInsumo13);
			articuloInsumoRepository.save(articuloInsumo14);
			articuloInsumoRepository.save(articuloInsumo15);


			calendar.set(2024,1,1);
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo1=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.precioCosto(20.50)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo2=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo2)
					.fecha(calendar.getTime())
					.precioCosto(12.50)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo3=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo3)
					.fecha(calendar.getTime())
					.precioCosto(8.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo4=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo4)
					.fecha(calendar.getTime())
					.precioCosto(22.00)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo5=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo5)
					.fecha(calendar.getTime())
					.precioCosto(19.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo6=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo6)
					.fecha(calendar.getTime())
					.precioCosto(9.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo7=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo7)
					.fecha(calendar.getTime())
					.precioCosto(18.89)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo8=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo8)
					.fecha(calendar.getTime())
					.precioCosto(16.23)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo9=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo9)
					.fecha(calendar.getTime())
					.precioCosto(23.23)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo10=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo10)
					.fecha(calendar.getTime())
					.precioCosto(09.88)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo11=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo11)
					.fecha(calendar.getTime())
					.precioCosto(7.25)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo12=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo12)
					.fecha(calendar.getTime())
					.precioCosto(7.85)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo13=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo13)
					.fecha(calendar.getTime())
					.precioCosto(19.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo14=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo14)
					.fecha(calendar.getTime())
					.precioCosto(24.63)
					.build();
			calendar.set(2024,2,1);
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo15=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.precioCosto(25.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo16=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo2)
					.fecha(calendar.getTime())
					.precioCosto(19.50)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo17=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo3)
					.fecha(calendar.getTime())
					.precioCosto(10.00)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo18=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo4)
					.fecha(calendar.getTime())
					.precioCosto(22.50)
					.build();
			calendar.set(2024,3,1);
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo19=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.precioCosto(27.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo20=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo2)
					.fecha(calendar.getTime())
					.precioCosto(19.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo21=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo3)
					.fecha(calendar.getTime())
					.precioCosto(12.50)
					.build();
			calendar.set(2024,4,1);
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo22=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.precioCosto(29.99)
					.build();
			HistoricoPrecioArticuloInsumo historicoPrecioArticuloInsumo23=HistoricoPrecioArticuloInsumo.builder()
					.articuloInsumo(articuloInsumo2)
					.fecha(calendar.getTime())
					.precioCosto(22.50)
					.build();


			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo1);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo2);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo3);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo4);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo5);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo6);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo7);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo8);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo9);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo10);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo11);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo12);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo13);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo14);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo15);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo16);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo17);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo18);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo19);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo20);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo21);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo22);
			historicoPrecioArticuloInsumoRepository.save(historicoPrecioArticuloInsumo23);
			calendar.set(2024,2,1);
			HistoricoStock historicoStock1=HistoricoStock.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.stock(13).build();
			HistoricoStock historicoStock2=HistoricoStock.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.stock(11).build();
			HistoricoStock historicoStock3=HistoricoStock.builder()
					.articuloInsumo(articuloInsumo1)
					.fecha(calendar.getTime())
					.stock(33).build();

			historicoStockRepository.save(historicoStock1);
			historicoStockRepository.save(historicoStock2);
			historicoStockRepository.save(historicoStock3);

			ArticuloManufacturado articuloManufacturado1=ArticuloManufacturado.builder()
					.denominacion("Pizza con huevo")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("Pizza con muzzarella y huevo")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado2=ArticuloManufacturado.builder()
					.denominacion("Pizza Especial")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("pizza con muzzarella y jamon")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado3=ArticuloManufacturado.builder()
					.denominacion("Pizza normal")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("pizza con queso muzzarella")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado4=ArticuloManufacturado.builder()
					.denominacion("Papas chicas")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("Bandeja chica de papas")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado5=ArticuloManufacturado.builder()
					.denominacion("Papas Grandes")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("Bandeja Grande de papas")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado6=ArticuloManufacturado.builder()
					.denominacion("Hamburguesa simple")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("Hamburguesa sencilla")
					.tiempoEstimadoEnMinutos(30)
					.build();
			ArticuloManufacturado articuloManufacturado7=ArticuloManufacturado.builder()
					.denominacion("Lomo de 20 cm")
					.unidadMedida(unidadMedida4)
					.imagen(imagen4)
					.categoria(categoria4)
					.Preparacion("Lomo para 2 personas")
					.tiempoEstimadoEnMinutos(30)
					.build();

			articuloManufacturadoRepository.save(articuloManufacturado1);
			articuloManufacturadoRepository.save(articuloManufacturado2);
			articuloManufacturadoRepository.save(articuloManufacturado3);
			articuloManufacturadoRepository.save(articuloManufacturado4);
			articuloManufacturadoRepository.save(articuloManufacturado5);
			articuloManufacturadoRepository.save(articuloManufacturado6);
			articuloManufacturadoRepository.save(articuloManufacturado7);

			ArticuloManufacturadoDetalle articuloManufacturadoDetalle1=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo2)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle2=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo4)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle3=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle4=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo12)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle5=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado2)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle6=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo2)
					.articuloManufacturado(articuloManufacturado2)
					.cantidad(100.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle7=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo4)
					.articuloManufacturado(articuloManufacturado2)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle8=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo13)
					.articuloManufacturado(articuloManufacturado2)
					.cantidad(50.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle9=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado3)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle10=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo2)
					.articuloManufacturado(articuloManufacturado3)
					.cantidad(100.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle11=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo4)
					.articuloManufacturado(articuloManufacturado3)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle12=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(2.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle13=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado2)
					.cantidad(2.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle14=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle15=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado3)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle16=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado4)
					.cantidad(2.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle17=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo15)
					.articuloManufacturado(articuloManufacturado4)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle18=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado1)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle19=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado5)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle20=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo15)
					.articuloManufacturado(articuloManufacturado5)
					.cantidad(500.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle21=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo10)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(1.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle22=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(1.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle23=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo5)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(50.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle24=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo6)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(20.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle25=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo7)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(20.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle26=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo8)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(150.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle27=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado6)
					.cantidad(3.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle28=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo11)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(1.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle29=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo1)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(1.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle30=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo5)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(75.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle31=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo6)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(25.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle32=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo7)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(25.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle33=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo9)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(200.0).build();
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle34=ArticuloManufacturadoDetalle.builder()
					.articuloInsumo(articuloInsumo14)
					.articuloManufacturado(articuloManufacturado7)
					.cantidad(4.0).build();


			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle3);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle2);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle1);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle4);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle5);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle6);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle7);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle8);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle9);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle10);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle11);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle12);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle13);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle14);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle15);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle16);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle17);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle18);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle19);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle20);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle21);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle22);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle23);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle24);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle25);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle26);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle27);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle28);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle29);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle30);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle31);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle32);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle33);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle34);

		};
	}
}