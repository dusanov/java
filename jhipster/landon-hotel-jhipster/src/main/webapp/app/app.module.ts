import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { LandonhotelSharedModule } from 'app/shared/shared.module';
import { LandonhotelCoreModule } from 'app/core/core.module';
import { LandonhotelAppRoutingModule } from './app-routing.module';
import { LandonhotelHomeModule } from './home/home.module';
import { LandonhotelEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    LandonhotelSharedModule,
    LandonhotelCoreModule,
    LandonhotelHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    LandonhotelEntityModule,
    LandonhotelAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class LandonhotelAppModule {}
