MyApp.factory('service', ['$http', "$q", function($http, $q) {
	
	// implementation
    function getHttp(uri) {
        var def = $q.defer();       
        $http.get(uri)
           .then(function(response) {
    		def.resolve(response);
        }).catch(function(err) {
        	 def.reject("Error en la consulta del servicio: ", err);
        });      
        return def.promise;
    }
	
	return {
		getHttp : getHttp
	};
	
}]);