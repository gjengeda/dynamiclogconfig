(function () {

	APP.Models.Logger = Backbone.Model.extend({

    	url: "/rest/logconfig/setLevel",
    	idAttribute: "name",
    	
        getName: function(){
            return this.get("name");
        },

        getLevel: function(){
        	return this.get("level");
        },
        
        getLogLevels: function(){
        	return [{val: ""}, {val: "TRACE"}, {val: "DEBUG"}, {val: "INFO"}, {val: "WARN"}, {val: "ERROR"}];
        },
        
        setLevel: function(level){
        	this.set("level",level);
        }
        
    });

})();