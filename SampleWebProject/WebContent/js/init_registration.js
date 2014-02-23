/* 
  IMPORTANT: To Link this Javascript File

  Click 'Menu' button at the top and select 'Copy Link' 
*/ 



/*
	Prologue 1.1 by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
*/

/*********************************************************************************/
/* Settings                                                                      */
/*********************************************************************************/

	var prologue_settings = {

		// skelJS (probably don't need to change anything here unless you know what you're doing)
			skelJS: {
				prefix: 'css/style',
				resetCSS: true,
				boxModel: 'border',
				useOrientation: true,
				breakpoints: {
					'widest':	{ range: '1881-', hasStyleSheet: false, containers: 1400, grid: { gutters: 70 } },
					'wide':	{ range: '961-1880', containers: 1200, grid: { gutters: 40 } },
					'normal':	{ range: '961-1620', containers: 960, grid: { gutters: 40 } },
					'narrow':	{ range: '961-1320', containers: 'fluid', grid: { gutters: 30 } },
					'narrower':	{ range: '-960', containers: 'fluid', grid: { gutters: 30 } },
					'mobile':	{ range: '-640', containers: 'fluid', lockViewport: true, grid: { gutters: 30, collapse: true } }
				}
			}
	};

/*********************************************************************************/
/* Don't modify beyond this point unless you know what you're doing!             */
/*********************************************************************************/

// Initialize skelJS
	skel.init(prologue_settings.skelJS, prologue_settings.skelJSPlugins);


