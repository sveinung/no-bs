define(function(require) {

    var mustache = require('mustache');

    var renderTemplate = function(template) {
        return mustache.render(template);
    };

    return renderTemplate;
});
