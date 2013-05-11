#!/usr/bin/env node

require('shelljs/make');
require('colors');

var path = require('path'),
    moment = require('moment'),
    _ = require('underscore');

var version = process.env.VERSION || moment().format('YYYYMMDD'),
    buildDir = process.env.OUTPUT_DIR || path.join('build', 'frontend-build');

var config = path.join('src', 'main', 'config'),
    jsFileName = 'app-' + version + '.js',
    jsFile = path.join(buildDir, jsFileName);

target.all = function() {
    target.build();
};

target.build = function() {
    var rjsConfig = path.join(config, 'buildconfig.js');
    npmBin('r.js', '-o ' + rjsConfig, 'out=' + jsFile);
};

var npmBin = function(name) {
    var bin = path.join('node_modules', '.bin', name);

    if (!test('-e', bin)) {
        echo('Binary does not exist: ' + bin);
        exit(1);
    }

    var res = exec(bin + ' ' + _.rest(arguments).join(' '));
    done(res);
};

var done = function(res) {
    if (res.code === 0) {
        success();
    } else {
        fail();
    }
};

var success = function(text) {
    text = text || 'done';
    var s = '✓';
    echo('    ' + s.green + ' ' + text.green);
};

var fail = function(text) {
    text = text || 'failed';
    var s = '✘';
    echo('    ' + s.red + ' ' + text.red);
    exit(1);
};
