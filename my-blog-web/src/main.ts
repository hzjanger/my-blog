import 'hammerjs';
import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import {AppModule} from './app/app.module';
import {environment} from './environments/environment';

if (environment.production) {
  enableProdMode();
}

// platformBrowserDynamic().bootstrapModule(AppModule)
//   .catch(err => console.error(err));


const bootstrap = () => {
  return platformBrowserDynamic().bootstrapModule(AppModule);
};

bootstrap().then(() => {
  const spinner = document.getElementById('nb-global-spinner');
  if (spinner) {
    spinner.style.display = 'none';
  }
}).catch(err => console.error(err));
