// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
var MyApp = angular.module("MyApp", []);

MyApp.controller("MyController",["$scope", "service", function($scope, service){
    	
	// Modelo de datos del negocio
	$scope.year = "";   // annio
	$scope.month = "";  // Mes
	$scope.days = "";   // days
	
	$scope.years = {};	 // annios
	$scope.months = {};	 // meses

	// Consultas de annios
	$scope.getDates = function(){
	  service.getHttp("/date/dates")
	  .then(function(response) {
  		$scope.years = response.data.list;
      }).catch(function(err) {
      	console.error("Error del servicio consulta años: ", err);          
      });
	};

	// Consultar de meses
	$scope.getMonths = function(){
	  service.getHttp("/date/months")
	  .then(function(response) {
  		$scope.months = response.data.list;
      }).catch(function(err) {
      	console.error("Error del servicio consulta de meses: ", err);          
      });
	};
	
	// Consultas de annios
	$scope.getDays = function(){
		console.log("$scope.year: ", $scope.year);
		console.log("$scope.month: ", $scope.month);
		
	  service.getHttp("/date/days/" + $scope.year.value + "/" + $scope.month.value)
	  .then(function(response) {
  		$scope.days = response.data.list;
      }).catch(function(err) {
      	console.error("Error del servicio consulta dias segun el mes y año requerido: ", err);          
      });
	};
	
	// Cargar data inicial
	$scope.getDates();
	$scope.getMonths();
    	    	
}]);