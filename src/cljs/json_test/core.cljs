(ns json-test.core
    (:require [reagent.core :as reagent :refer [atom]]
              [ajax.core :refer [GET]]
              [json-html.core :refer [json->hiccup]]))

(defn my-element [url]
	(let [data (reagent/atom nil)]
		(fn [_]
			(if-some [d @data]
        [json->hiccup d]
        [:button {:on-click #(GET url {:handler (partial reset! data)})}
         "load it"]))))

(defn my-app []
  [:div 
   [my-element "https://jsonplaceholder.typicode.com/posts"]])
;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [my-app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
