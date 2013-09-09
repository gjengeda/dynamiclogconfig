(function () {
  "use strict";
  APP.Views.LoggerRowView = Backbone.View.extend({

    tagName: "tr",

    events: {
    	"change .logLevelSelect" : "updateLogLevel"
    },
    
    initialize: function (options) {
      this.logger  = options.logger;
    },

    render: function () {
      this.$el.html(_.template($('#rowTemplate').html(), this.logger));
      return this;
    },

    updateLogLevel: function(event){
    	var $logLevelSelect = $(event.target);
    	var $selectedOption = $logLevelSelect.find(":selected");
    	this.logger.setLevel($selectedOption.val());
    	this.logger.save();
    }

  });
}());
