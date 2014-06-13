define(function(require) {

    var mustache = require('mustache');

    var renderTemplate = function(template, data) {
        data = (data || {});
        return mustache.render(template, data);
    };

    return renderTemplate;
});
