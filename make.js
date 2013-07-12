#!/usr/bin/env node

require('shelljs/make');
require('colors');

var path = require('path'),
    moment = require('moment'),
    _ = require('underscore'),
    npmBin = require('npm-bin');

var version = process.env.VERSION || moment().format('YYYYMMDD'),
    buildDir = process.env.OUTPUT_DIR || path.join('build', 'frontend-build');

var config = path.join('src', 'main', 'config'),
    jsFileName = 'app-' + version + '.js',
    jsFile = path.join(buildDir, jsFileName);

target.all = function() {
    target.test();
    target.build();
};

target.test = function() {
    section('Running JavaScript tests');
    bin('karma', ['start', 'karma.conf.js', '--browsers PhantomJS', '--single-run']);
};

target.browser = function() {
    section('Running JavaScript tests in browser');
    bin('karma', ['start', 'karma.conf.js']);
};

target.build = function() {
    var rjsConfig = path.join(config, 'buildconfig.js');
    bin('r.js', ['-o ' + rjsConfig, 'out=' + jsFile]);
};

var bin = function(name, args, options) {
    var res = npmBin(name, args, options)
    done(res);
};

var section = function(header) {
    echo();
    echo('    ' + header.bold);
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
