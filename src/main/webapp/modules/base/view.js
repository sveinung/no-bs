define(function(require) {

    var Backbone = require('backbone'),
        renderTemplate = require('./renderTemplate');

    var BaseView = Backbone.View.extend({
        renderTemplate: function(template, data) {
            this.$el.html(renderTemplate(template, data));
        }
    });

    return BaseView;
});
