package co.edu.smartgym.controller;

import co.edu.smartgym.factory.PlanBasicoFactory;
import co.edu.smartgym.factory.PlanFactory;
import co.edu.smartgym.factory.PlanPersonalizadoFactory;
import co.edu.smartgym.factory.PlanPremiumFactory;
import co.edu.smartgym.model.*;
import co.edu.smartgym.service.GestionGimnasio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PrincipalController {

    private final Gimnasio gimnasio = new Gimnasio(
            "SmartGym",
            "900123456-7",
            "Armenia, Quindío",
            "3001234567",
            "contacto@smartgym.com",
            "www.smartgym.com"
    );

    private final GestionGimnasio gestion = new GestionGimnasio(gimnasio);

    @FXML private TabPane tabPane;

    // Clientes
    @FXML private TextField txtNombreCliente;
    @FXML private TextField txtDocumentoCliente;
    @FXML private TextField txtTelefonoCliente;
    @FXML private TextField txtCorreoCliente;
    @FXML private TextField txtEdadCliente;
    @FXML private DatePicker dpFechaCliente;
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colClienteNombre;
    @FXML private TableColumn<Cliente, String> colClienteDocumento;
    @FXML private TableColumn<Cliente, String> colClienteTelefono;
    @FXML private TableColumn<Cliente, String> colClienteCorreo;

    // Entrenadores
    @FXML private TextField txtDocumentoEntrenador;
    @FXML private TextField txtNombreEntrenador;
    @FXML private TextField txtEspecialidadEntrenador;
    @FXML private TextField txtTelefonoEntrenador;
    @FXML private TextField txtTarifaEntrenador;
    @FXML private TableView<Entrenador> tablaEntrenadores;
    @FXML private TableColumn<Entrenador, String> colEntrenadorDocumento;
    @FXML private TableColumn<Entrenador, String> colEntrenadorNombre;
    @FXML private TableColumn<Entrenador, String> colEntrenadorEspecialidad;
    @FXML private TableColumn<Entrenador, String> colEntrenadorTelefono;
    @FXML private TableColumn<Entrenador, Double> colEntrenadorTarifa;

    // Planes
    @FXML private ComboBox<String> cbTipoPlan;
    @FXML private TextField txtCodigoPlan;
    @FXML private TextField txtNombrePlan;
    @FXML private TextField txtDescripcionPlan;
    @FXML private TextField txtDuracionPlan;
    @FXML private TextField txtValorPlan;
    @FXML private TextField txtSesionesPlan;
    @FXML private TextField txtEspecialidadPlan;
    @FXML private TextField txtObjetivoPlan;
    @FXML private TableView<PlanEntrenamiento> tablaPlanes;
    @FXML private TableColumn<PlanEntrenamiento, String> colPlanCodigo;
    @FXML private TableColumn<PlanEntrenamiento, String> colPlanNombre;
    @FXML private TableColumn<PlanEntrenamiento, Integer> colPlanDuracion;
    @FXML private TableColumn<PlanEntrenamiento, Double> colPlanValor;
    @FXML private TableColumn<PlanEntrenamiento, Estado> colPlanEstado;

    // Servicios
    @FXML private ComboBox<TipoServicio> cbTipoServicio;
    @FXML private TextField txtCodigoServicio;
    @FXML private TextField txtNombreServicio;
    @FXML private TextField txtDescripcionServicio;
    @FXML private TextField txtPrecioServicio;
    @FXML private CheckBox chkDisponibleServicio;
    @FXML private TableView<ServicioAdicional> tablaServicios;
    @FXML private TableColumn<ServicioAdicional, String> colServicioCodigo;
    @FXML private TableColumn<ServicioAdicional, String> colServicioNombre;
    @FXML private TableColumn<ServicioAdicional, Double> colServicioPrecio;
    @FXML private TableColumn<ServicioAdicional, Boolean> colServicioDisponible;

    // Inscripciones
    @FXML private ComboBox<Cliente> cbClienteInscripcion;
    @FXML private ComboBox<PlanEntrenamiento> cbPlanInscripcion;
    @FXML private ComboBox<Entrenador> cbEntrenadorInscripcion;
    @FXML private DatePicker dpFechaInscripcion;
    @FXML private TextField txtDescuentoInscripcion;
    @FXML private ListView<ServicioAdicional> listaServiciosInscripcion;
    @FXML private TableView<Inscripcion> tablaInscripciones;
    @FXML private TableColumn<Inscripcion, String> colInscripcionCliente;
    @FXML private TableColumn<Inscripcion, String> colInscripcionPlan;
    @FXML private TableColumn<Inscripcion, LocalDate> colInscripcionFecha;
    @FXML private TableColumn<Inscripcion, Double> colInscripcionTotal;

    // Reportes
    @FXML private TextField txtTelefonoBusqueda;
    @FXML private Label lblClienteEncontrado;
    @FXML private Label lblNumeroPerfecto;
    @FXML private DatePicker dpInicioReporte;
    @FXML private DatePicker dpFinReporte;
    @FXML private Label lblIngresos;

    @FXML
    public void initialize() {
        configurarTablas();

        cbTipoPlan.setItems(FXCollections.observableArrayList(
                "Básico", "Premium", "Personalizado"
        ));
        cbTipoPlan.setValue("Básico");

        cbTipoServicio.setItems(FXCollections.observableArrayList(
                TipoServicio.values()
        ));
        cbTipoServicio.setValue(TipoServicio.VALORACIONFISICA);

        dpFechaCliente.setValue(LocalDate.now());
        dpFechaInscripcion.setValue(LocalDate.now());

        chkDisponibleServicio.setSelected(true);

        refrescarTodo();
    }

    private void configurarTablas() {
        colClienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colClienteDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colClienteTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colClienteCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        colEntrenadorDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colEntrenadorNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEntrenadorEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colEntrenadorTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEntrenadorTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifaSesion"));

        colPlanCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPlanNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPlanDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        colPlanValor.setCellValueFactory(new PropertyValueFactory<>("valorMensual"));
        colPlanEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        colServicioCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colServicioNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colServicioPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colServicioDisponible.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));

        colInscripcionCliente.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getCliente().getNombre()
                )
        );
        colInscripcionPlan.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getPlan().getNombre()
                )
        );
        colInscripcionFecha.setCellValueFactory(
                new PropertyValueFactory<>("fechaInscripcion")
        );
        colInscripcionTotal.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        data.getValue().calcularValor()
                )
        );
    }

    @FXML
    private void registrarCliente() {
        try {
            Cliente cliente = new Cliente(
                    obligatorio(txtNombreCliente.getText(), "Nombre"),
                    obligatorio(txtDocumentoCliente.getText(), "Documento"),
                    obligatorio(txtTelefonoCliente.getText(), "Teléfono"),
                    obligatorio(txtCorreoCliente.getText(), "Correo"),
                    Integer.parseInt(txtEdadCliente.getText()),
                    dpFechaCliente.getValue()
            );

            gimnasio.registrarCliente(cliente);
            mostrarInfo("Cliente registrado correctamente.");
            limpiarClientes();
            refrescarTodo();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarEntrenador() {
        try {
            Entrenador entrenador = new Entrenador(
                    obligatorio(txtDocumentoEntrenador.getText(), "Documento"),
                    obligatorio(txtNombreEntrenador.getText(), "Nombre"),
                    obligatorio(txtEspecialidadEntrenador.getText(), "Especialidad"),
                    obligatorio(txtTelefonoEntrenador.getText(), "Teléfono"),
                    Double.parseDouble(txtTarifaEntrenador.getText())
            );

            gimnasio.registrarEntrenador(entrenador);
            mostrarInfo("Entrenador registrado correctamente.");
            limpiarEntrenadores();
            refrescarTodo();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarPlan() {
        try {
            String tipo = cbTipoPlan.getValue();
            String codigo = obligatorio(txtCodigoPlan.getText(), "Código");
            String nombre = obligatorio(txtNombrePlan.getText(), "Nombre");
            String descripcion = txtDescripcionPlan.getText();
            int duracion = Integer.parseInt(txtDuracionPlan.getText());
            double valor = Double.parseDouble(txtValorPlan.getText());

            PlanFactory factory;

            switch (tipo) {
                case "Premium" -> factory = new PlanPremiumFactory();
                case "Personalizado" -> {
                    int sesiones = Integer.parseInt(txtSesionesPlan.getText());
                    String especialidad = obligatorio(
                            txtEspecialidadPlan.getText(), "Especialidad requerida"
                    );
                    String objetivo = obligatorio(
                            txtObjetivoPlan.getText(), "Objetivo del cliente"
                    );

                    factory = new PlanPersonalizadoFactory(
                            sesiones, especialidad, objetivo
                    );
                }
                default -> factory = new PlanBasicoFactory();
            }

            PlanEntrenamiento plan = factory.crearPlan(
                    codigo, nombre, descripcion, duracion, valor
            );

            gimnasio.registrarPlan(plan);

            mostrarInfo("Plan registrado correctamente.");
            limpiarPlanes();
            refrescarTodo();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarServicio() {
        try {
            ServicioAdicional servicio = new ServicioAdicional(
                    cbTipoServicio.getValue(),
                    obligatorio(txtCodigoServicio.getText(), "Código"),
                    obligatorio(txtNombreServicio.getText(), "Nombre"),
                    txtDescripcionServicio.getText(),
                    Double.parseDouble(txtPrecioServicio.getText()),
                    chkDisponibleServicio.isSelected()
            );

            gimnasio.registrarServicio(servicio);

            mostrarInfo("Servicio registrado correctamente.");
            limpiarServicios();
            refrescarTodo();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void registrarInscripcion() {
        try {
            Cliente cliente = cbClienteInscripcion.getValue();
            PlanEntrenamiento plan = cbPlanInscripcion.getValue();

            if (cliente == null || plan == null) {
                throw new IllegalArgumentException(
                        "Debe seleccionar cliente y plan."
                );
            }

            Entrenador entrenador = cbEntrenadorInscripcion.getValue();

            if (!(plan instanceof PlanPersonalizado)) {
                entrenador = null;
            }

            double descuento = Double.parseDouble(
                    txtDescuentoInscripcion.getText().isBlank()
                            ? "0"
                            : txtDescuentoInscripcion.getText()
            );

            Inscripcion inscripcion = new Inscripcion(
                    cliente,
                    plan,
                    entrenador,
                    dpFechaInscripcion.getValue(),
                    descuento
            );

            for (ServicioAdicional servicio :
                    listaServiciosInscripcion.getSelectionModel().getSelectedItems()) {
                inscripcion.agregarServicio(servicio);
            }

            gimnasio.registrarInscripcion(inscripcion);

            mostrarInfo(
                    "Inscripción registrada.\nTotal: $"
                            + String.format("%.2f", inscripcion.calcularValor())
            );

            limpiarInscripcion();
            refrescarTodo();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void buscarCliente() {
        String telefono = txtTelefonoBusqueda.getText();

        if (telefono == null || telefono.isBlank()) {
            mostrarError("Ingrese un número de teléfono.");
            return;
        }

        Cliente cliente = gestion.buscarClientePorTelefono(telefono);

        if (cliente == null) {
            lblClienteEncontrado.setText("Cliente: no encontrado");
        } else {
            lblClienteEncontrado.setText(
                    "Cliente: " + cliente.getNombre()
                            + " | Documento: " + cliente.getDocumento()
            );
        }

        boolean perfecto = gestion.esNumeroPerfecto(telefono);

        lblNumeroPerfecto.setText(
                "¿El número es perfecto?: " + (perfecto ? "Sí" : "No")
        );
    }

    @FXML
    private void calcularIngresos() {
        try {
            LocalDate inicio = dpInicioReporte.getValue();
            LocalDate fin = dpFinReporte.getValue();

            double total = gestion.calcularIngresos(inicio, fin);

            lblIngresos.setText(
                    "Ingresos del periodo: $"
                            + String.format("%.2f", total)
            );

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    private void refrescarTodo() {
        tablaClientes.setItems(
                FXCollections.observableArrayList(gimnasio.getListaClientes())
        );

        tablaEntrenadores.setItems(
                FXCollections.observableArrayList(gimnasio.getListaEntrenadores())
        );

        tablaPlanes.setItems(
                FXCollections.observableArrayList(
                        gimnasio.getListaPlanesEntrenamiento()
                )
        );

        tablaServicios.setItems(
                FXCollections.observableArrayList(gimnasio.getListaServicios())
        );

        tablaInscripciones.setItems(
                FXCollections.observableArrayList(gimnasio.getListaInscripciones())
        );

        cbClienteInscripcion.setItems(
                FXCollections.observableArrayList(gimnasio.getListaClientes())
        );

        cbPlanInscripcion.setItems(
                FXCollections.observableArrayList(
                        gimnasio.getListaPlanesEntrenamiento()
                )
        );

        cbEntrenadorInscripcion.setItems(
                FXCollections.observableArrayList(
                        gimnasio.getListaEntrenadores()
                )
        );

        listaServiciosInscripcion.setItems(
                FXCollections.observableArrayList(gimnasio.getListaServicios())
        );

        listaServiciosInscripcion.getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void limpiarClientes() {
        txtNombreCliente.clear();
        txtDocumentoCliente.clear();
        txtTelefonoCliente.clear();
        txtCorreoCliente.clear();
        txtEdadCliente.clear();
        dpFechaCliente.setValue(LocalDate.now());
    }

    private void limpiarEntrenadores() {
        txtDocumentoEntrenador.clear();
        txtNombreEntrenador.clear();
        txtEspecialidadEntrenador.clear();
        txtTelefonoEntrenador.clear();
        txtTarifaEntrenador.clear();
    }

    private void limpiarPlanes() {
        txtCodigoPlan.clear();
        txtNombrePlan.clear();
        txtDescripcionPlan.clear();
        txtDuracionPlan.clear();
        txtValorPlan.clear();
        txtSesionesPlan.clear();
        txtEspecialidadPlan.clear();
        txtObjetivoPlan.clear();
    }

    private void limpiarServicios() {
        txtCodigoServicio.clear();
        txtNombreServicio.clear();
        txtDescripcionServicio.clear();
        txtPrecioServicio.clear();
        chkDisponibleServicio.setSelected(true);
    }

    private void limpiarInscripcion() {
        cbClienteInscripcion.setValue(null);
        cbPlanInscripcion.setValue(null);
        cbEntrenadorInscripcion.setValue(null);
        txtDescuentoInscripcion.clear();
        listaServiciosInscripcion.getSelectionModel().clearSelection();
        dpFechaInscripcion.setValue(LocalDate.now());
    }

    private String obligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
        return valor.trim();
    }

    private void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SmartGym");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("SmartGym");
        alert.setHeaderText("No se pudo realizar la operación");
        alert.setContentText(
                mensaje == null ? "Verifique los datos ingresados." : mensaje
        );
        alert.showAndWait();
    }
}
