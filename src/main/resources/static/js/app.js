// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
var MyApp = angular.module("MyApp", []);

MyApp.controller("MyController",["$scope", "service", function($scope, service){
    	
	// Modelo de negocio
	$scope.year = "";   // annio
	$scope.month = "";  // Mes
	$scope.day = "";   // dia
	$scope.showMonth = false;
	$scope.showDay = false;
	$scope.nameDay = "";
	
	$scope.startDate = "";   		// Fecha inicial
	$scope.endDate = "";   			// Fecha final
	$scope.daysBetweenDates = "";   // Dias entre fechas
	
	// Modelo de datos
	$scope.years = {};	 // annios
	$scope.months = {};	 // meses
	$scope.days = "";   // dias

	// Consultas de annios
	$scope.getDates = function() {
	  service.getHttp("/date/dates")
	  .then(function(response) {
  		$scope.years = response.data.list;
  		
  		// Inicializar valores
  		$scope.year = $scope.years[0];   // annio
  		
      }).catch(function(err) {
      	console.error("Error del servicio consulta años: ", err);          
      });
	};

	// Consultar de meses
	$scope.getMonths = function() {
	  service.getHttp("/date/months")
	  .then(function(response) {
  		$scope.months = response.data.list;
  		
  		// Inicializar valores
  		$scope.month = $scope.months[0];  // Mes
  		$scope.showMonth = true;
  		$scope.showDay = false;
      }).catch(function(err) {
      	console.error("Error del servicio consulta de meses: ", err);          
      });
	};
	
	// Consultas dias de un mes/annio
	$scope.getDays = function() {
		if(null != $scope.month && -1 != $scope.month.key) {
			
		  service.getHttp("/date/days/" + $scope.year.value + "/" + $scope.month.key)
		  .then(function(response) {
	  		$scope.days = response.data.list;
	  		
	  		// Inicializar valores
	  		$scope.day = $scope.days[0];  // dias
	  		$scope.showDay = true;
	  		
	      }).catch(function(err) {
	      	console.error("Error del servicio consulta dias segun el mes y año requerido: ", err);          
	      });
		} else {
			$scope.day = "";  // dia
		  	$scope.days = {};  // dias
		  	$scope.showDay = false;
		}
		$scope.nameDay = "";
	};
	
	// Consultar dia de la semana [LUNES/MARTES...]
	$scope.getNameDayByDate = function(){
		if(null != $scope.day && -1 != $scope.day.key) {
			  service.getHttp("/date/nameDay/"+$scope.day.value+"/"+$scope.month.key+"/"+$scope.year.value)
			  .then(function(response) { 		
		  		$scope.nameDay = response.data.nameDay;
		      }).catch(function(err) {
		      	console.error("Error del servicio consulta dias segun el mes y año requerido: ", err);          
		      });
		} else {
			$scope.nameDay = "";
		}
	};
	
	// Calcular los dias  entre dos fechas
	$scope.getdaysBetweenDates = function(){
	  service.getHttp("/date/daysBetweenDates/"+$scope.startDate+"/"+$scope.endDate)
	  .then(function(response) { 		
  		$scope.daysBetweenDates = response.data.nameDay;
      }).catch(function(err) {
      	console.error("Error del servicio consulta los dias entre fechas: ", err);          
      });
	};
	
	// Cargar data inicial
	$scope.getDates();
  
	$scope.initData = function() {
		if(-1 === $scope.year.key) {
			// Inicializar valores
	  		$scope.year = $scope.years[0];  // annio
	  		$scope.month = $scope.months[0];  // mes
	  		
	  		$scope.months = {};
	  		$scope.showMonth = false;
	  		
	  		$scope.day = "";  // dia
		  	$scope.days = {};  // dias
		  	$scope.showDay = false;
		  	
		} else {
			$scope.getMonths();
		}
		$scope.nameDay = "";
	}
	
}]);