(ns ^:figwheel-no-load json-test.dev
  (:require
    [json-test.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
