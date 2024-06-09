package com.example.JPAElBuenSabor;

import com.example.JPAElBuenSabor.entities.*;
import com.example.JPAElBuenSabor.entities.enums.Roles;
import com.example.JPAElBuenSabor.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaElBuenSaborApplication{

	private static final Logger logger = LoggerFactory.getLogger(JpaElBuenSaborApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;
	/*
	@Autowired
	private ImagenRepository imagenPersonaRepository;
	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;
*/

	/*@Autowired
	private RolRepository rolRepository;*/

	@Autowired
	private HistoricoRolRepository historicoRolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

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
	private HorarioAperturaRepository horarioAperturaRepository;

	@Autowired
	private DomicilioClienteRepository domicilioClienteRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private TelefonoRepository telefonoRepository;
/*

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private ImagenRepository imagenArticuloRepository;

	@Autowired
	private PromocionRepository promocionRepository;

	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

	@Autowired
	private PedidoRepository pedidoRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(JpaElBuenSaborApplication.class, args);
		logger.info("Estoy activo en el main");
	}


	@Bean
	CommandLineRunner init() {
		return args -> {
			logger.info("----------------ESTOY----FUNCIONANDO---------------------");

			/*
			Categoria categoriaBebidas = Categoria.builder().denominacion("Bebidas").
					build();
			categoriaRepository.save(categoriaBebidas);

			Categoria categoriaGaseosas = Categoria.builder().denominacion("Gaseosas").
					build();
			categoriaRepository.save(categoriaGaseosas);

			Categoria categoriaTragos = Categoria.builder().denominacion("Tragos").
					build();
			categoriaRepository.save(categoriaTragos);

			Categoria categoriaPizzas = Categoria.builder().denominacion("Pizzas").
					build();

			Categoria categoriaInsumos = Categoria.builder().denominacion("Insumos").
					build();

			// Grabo la categoria de insumos y de Manufacturados
			categoriaRepository.save(categoriaPizzas);
			categoriaRepository.save(categoriaInsumos);
			// Asigno subCategorias

			categoriaBebidas.getSubCategorias().add(categoriaGaseosas);
			categoriaBebidas.getSubCategorias().add(categoriaTragos);
			// Grabo las Subcategorias
			categoriaRepository.save(categoriaBebidas);

			// Crear Unidades de medida
			UnidadMedida unidadMedidaLitros = UnidadMedida.builder().denominacion("Litros").build();
			UnidadMedida unidadMedidaGramos = UnidadMedida.builder().denominacion("Gramos").build();
			UnidadMedida unidadMedidaCantidad = UnidadMedida.builder().denominacion("Cantidad").build();
			UnidadMedida unidadMedidaPorciones = UnidadMedida.builder().denominacion("Porciones").build();
			unidadMedidaRepository.save(unidadMedidaLitros);
			unidadMedidaRepository.save(unidadMedidaGramos);
			unidadMedidaRepository.save(unidadMedidaCantidad);
			unidadMedidaRepository.save(unidadMedidaPorciones);

			// Crear Insumos , coca cola , harina , etc
			ArticuloInsumo cocaCola = ArticuloInsumo.builder().
					denominacion("Coca cola").
					esParaElaborar(false).
					stockActual(5).
					stockMaximo(50).
					build();
			ArticuloInsumo harina = ArticuloInsumo.builder().denominacion("Harina").esParaElaborar(true).stockActual(4).stockMaximo(40).build();
			ArticuloInsumo queso = ArticuloInsumo.builder().denominacion("Queso").esParaElaborar(true).stockActual(20).stockMaximo(50).build();
			ArticuloInsumo tomate = ArticuloInsumo.builder().denominacion("Tomate").esParaElaborar(true).stockActual(20).stockMaximo(50).build();
			// Grabamos los Articulos
			articuloInsumoRepository.save(cocaCola);
			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);

			cocaCola.setUnidadMedida(unidadMedidaLitros);
			harina.setUnidadMedida(unidadMedidaGramos);
			queso.setUnidadMedida(unidadMedidaGramos);
			tomate.setUnidadMedida(unidadMedidaCantidad);

			articuloInsumoRepository.save(cocaCola);
			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);

			unidadMedidaLitros.getArticulos().add(cocaCola);
			unidadMedidaGramos.getArticulos().add(harina);
			unidadMedidaGramos.getArticulos().add(queso);
			unidadMedidaCantidad.getArticulos().add(tomate);

			unidadMedidaRepository.save(unidadMedidaLitros);
			unidadMedidaRepository.save(unidadMedidaGramos);
			unidadMedidaRepository.save(unidadMedidaCantidad);
			unidadMedidaRepository.save(unidadMedidaPorciones);



			// crear fotos para cada insumo
			Imagen imagenArticuloCoca = Imagen.builder().
					url("https://m.media-amazon.com/images/I/51v8nyxSOYL._SL1500_.jpg").
					build();
			Imagen imagenArticuloHarina = Imagen.builder().url("https://mandolina.co/wp-content/uploads/2023/03/648366622-1024x683.jpg").build();
			Imagen imagenArticuloQueso = Imagen.builder().url("https://superdepaso.com.ar/wp-content/uploads/2021/06/SANTAROSA-PATEGRAS-04.jpg").build();
			Imagen imagenArticuloTomate = Imagen.builder().url("https://thefoodtech.com/wp-content/uploads/2020/06/Componentes-de-calidad-en-el-tomate-828x548.jpg").build();

			imagenArticuloRepository.save(imagenArticuloCoca);
			imagenArticuloRepository.save(imagenArticuloHarina);
			imagenArticuloRepository.save(imagenArticuloQueso);
			imagenArticuloRepository.save(imagenArticuloTomate);

			//ASOCIAMOS IMAGEN CON INSUMOS
			cocaCola.setImagen(imagenArticuloCoca);
			harina.setImagen(imagenArticuloHarina);
			queso.setImagen(imagenArticuloQueso);
			tomate.setImagen(imagenArticuloTomate);

			articuloInsumoRepository.save(cocaCola);
			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);


			logger.info("Hasta aca llego");



			harina.setCategoria(categoriaInsumos);
			queso.setCategoria(categoriaInsumos);
			tomate.setCategoria(categoriaInsumos);
			cocaCola.setCategoria(categoriaBebidas);

			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);
			articuloInsumoRepository.save(cocaCola);


//			//ASOCIAMOS CATEGORIA CON INSUMOS
			categoriaInsumos.getArticulos().add(harina);
			categoriaInsumos.getArticulos().add(queso);
			categoriaInsumos.getArticulos().add(tomate);
			categoriaGaseosas.getArticulos().add(cocaCola);
			categoriaRepository.save(categoriaInsumos);
			categoriaRepository.save(categoriaGaseosas);

//			// Crear Articulos Manufacturados
			ArticuloManufacturado pizzaMuzarella = ArticuloManufacturado.builder().
					denominacion("Pizza Muzarella").
					descripcion("Una pizza clasica").
					tiempoEstimadoMinutos(15).
					preparacion("Pasos de preparacion de una muzza de toda la vida").
					build();
			ArticuloManufacturado pizzaNapolitana = ArticuloManufacturado.builder().
					denominacion("Pizza Napolitana").descripcion("Una pizza clasica").
					tiempoEstimadoMinutos(15).
					preparacion("Pasos de preparacion de una pizza napolitana italiana").
					build();

			articuloManufacturadoRepository.save(pizzaMuzarella);
			articuloManufacturadoRepository.save(pizzaNapolitana);

			// Crear fotos para los articulos manufacturados
			Imagen imagenArticuloPizzaMuzarella = Imagen.builder().
					url("https://storage.googleapis.com/fitia-api-bucket/media/images/recipe_images/1002846.jpg").
					build();
			Imagen imagenArticuloPizzaNapolitana = Imagen.builder().
					url("https://assets.elgourmet.com/wp-content/uploads/2023/03/8metlvp345_portada-pizza-1024x686.jpg.webp").
					build();
//			ImagenArticulo imagenArticuloQueso = ImagenArticulo.builder().
//					url("https://cdn2.cocinadelirante.com/sites/default/files/images/2023/09/como-hacer-queso-con-1-litro-de-leche.jpg").
//					build();

			imagenArticuloRepository.save(imagenArticuloPizzaMuzarella);
			imagenArticuloRepository.save(imagenArticuloPizzaNapolitana);
			//imagenArticuloRepository.save(imagenArticuloQueso);



			//ASOCIAMOS IMAGEN CON ARTICULO MANUFACTURADO
			pizzaMuzarella.setImagen(imagenArticuloPizzaMuzarella);
			pizzaNapolitana.setImagen(imagenArticuloPizzaNapolitana);
			//queso.getImagenes().add(imagenArticuloQueso);

			pizzaMuzarella.setUnidadMedida(unidadMedidaPorciones);
			pizzaNapolitana.setUnidadMedida(unidadMedidaPorciones);

			pizzaMuzarella.setCategoria(categoriaPizzas);
			pizzaNapolitana.setCategoria(categoriaPizzas);

			articuloManufacturadoRepository.save(pizzaMuzarella);
			articuloManufacturadoRepository.save(pizzaNapolitana);
			//articuloInsumoRepository.save(queso);
*/
			// Etapa del dashboard
			// Crear 1 pais
			// Crear 2 provincias para ese pais
			// crear 2 localidades para cada provincia
			Pais pais1 = Pais.builder().nombre("Argentina").build();
			paisRepository.save(pais1);

			//CREACION DE PROVINCIAS
			Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais1).build();
			Provincia provincia2 = Provincia.builder().nombre("Buenos Aires").pais(pais1).build();
			logger.info("----------------Etapa 1---------------------");
			provinciaRepository.save(provincia1);
			provinciaRepository.save(provincia2);
			logger.info("----------------Etapa 2---------------------");
			//CREACION DE LOCALIDADES

			Localidad localidad1 = Localidad.builder().nombre("Lujan de Cuyo").provincia(provincia1).build();
			Localidad localidad2 = Localidad.builder().nombre("Guaymallen").provincia(provincia1).build();
			Localidad localidad3 = Localidad.builder().nombre("Mar del Plata").provincia(provincia2).build();
			Localidad localidad4 = Localidad.builder().nombre("Mar de las Pampas").provincia(provincia2).build();

			logger.info("----------------Etapa 3---------------------");
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
					.usuario(usuario1)
					.build();
			Cliente cliente2=Cliente.builder()
					.nombre("Carlos")
					.fechaNacimiento(new Date())
					.apellido("Rodriguez")
					.usuario(usuario5)
					.build();
			Cliente cliente3=Cliente.builder()
					.nombre("Gerardo")
					.apellido("Magni")
					.usuario(usuario3)
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
					.fechaNacimiento(new Date())
					.build();
			Empleado empleado2=Empleado.builder()
					.legajo("1123")
					.apellido("Villavicencio")
					.nombre("Pablo")
					.usuario(usuario2)
					.fechaNacimiento(new Date())
					.sucursal(sucursal1).build();
			Empleado empleado3=Empleado.builder()
					.legajo("1223")
					.apellido("Vidal")
					.usuario(usuario6)
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

			HistoricoRol historicoRol1=HistoricoRol.builder().fecha(new Date()).persona(cliente1).rol(Roles.DELIVERY).build();
			HistoricoRol historicoRol2=HistoricoRol.builder().fecha(new Date()).persona(cliente2).rol(Roles.CLIENTE).build();
			HistoricoRol historicoRol3=HistoricoRol.builder().fecha(new Date()).persona(cliente3).rol(Roles.CLIENTE).build();
			HistoricoRol historicoRol4=HistoricoRol.builder().fecha(new Date()).persona(empleado3).rol(Roles.COCINERO).build();
			HistoricoRol historicoRol5=HistoricoRol.builder().fecha(new Date()).persona(empleado1).rol(Roles.ADMIN).build();
			HistoricoRol historicoRol6=HistoricoRol.builder().fecha(new Date()).persona(empleado2).rol(Roles.CAJERO).build();
			HistoricoRol historicoRol7=HistoricoRol.builder().fecha(new Date()).persona(cliente1).rol(Roles.CLIENTE).build();

			historicoRolRepository.save(historicoRol1);
			historicoRolRepository.save(historicoRol2);
			historicoRolRepository.save(historicoRol3);
			historicoRolRepository.save(historicoRol4);
			historicoRolRepository.save(historicoRol5);
			historicoRolRepository.save(historicoRol6);
			historicoRolRepository.save(historicoRol7);
		};
	}
}