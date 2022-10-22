import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MainComponent} from '@modules/main/main.component';
import {BlankComponent} from '@pages/blank/blank.component';
import {LoginComponent} from '@modules/login/login.component';
import {ProfileComponent} from '@pages/profile/profile.component';
import {RegisterComponent} from '@modules/register/register.component';
import {DashboardComponent} from '@pages/dashboard/dashboard.component';
import {AuthGuard} from '@guards/auth.guard';
import {NonAuthGuard} from '@guards/non-auth.guard';
import {ForgotPasswordComponent} from '@modules/forgot-password/forgot-password.component';
import {RecoverPasswordComponent} from '@modules/recover-password/recover-password.component';
import {MainMenuComponent} from '@pages/main-menu/main-menu.component';
import {SubMenuComponent} from '@pages/main-menu/sub-menu/sub-menu.component';
import {AddElectionComponent} from "@pages/Election/add-election/add-election.component";
import {ListElectionsComponent} from "@pages/Election/list-elections/list-elections.component";
import {DetailElectionComponent} from "@pages/Election/detail-election/detail-election.component";
import {UpdateElectionComponent} from "@pages/Election/update-election/update-election.component";
import {AddVoteComponent} from "@pages/Vote/add-vote/add-vote.component";
import {ListVotesComponent} from "@pages/Vote/list-votes/list-votes.component";
import {VoteStatsComponent} from "@pages/Vote/vote-stats/vote-stats.component";

const routes: Routes = [
    {
        path: '',
        component: MainComponent,
        // canActivate: [AuthGuard],
        // canActivateChild: [AuthGuard],
        children: [
            {
                path: 'add-election',
                component: AddElectionComponent
            },
            {
                path: 'list-elections',
                component: ListElectionsComponent
            },
            {
                path: 'detail-election/:id',
                component: DetailElectionComponent
            },
            {
                path: 'update-election/:id',
                component: UpdateElectionComponent
            },
            {
              path: 'add-vote',
              component: AddVoteComponent
            },
            {
              path: 'list-votes',
              component: ListVotesComponent
            },
            {
              path: 'vote-stats/:nomElection',
              component: VoteStatsComponent
            },
            {
                path: 'profile',
                component: ProfileComponent
            },
            {
                path: 'blank',
                component: BlankComponent
            },
            {
                path: 'sub-menu-1',
                component: SubMenuComponent
            },
            {
                path: 'sub-menu-2',
                component: MainMenuComponent
            },
            {
                path: '',
                component: DashboardComponent
            }
        ]
    },
    {
        path: 'login',
        component: LoginComponent,
        canActivate: [NonAuthGuard]
    },
    {
        path: 'register',
        component: RegisterComponent,
        canActivate: [NonAuthGuard]
    },
    {
        path: 'forgot-password',
        component: ForgotPasswordComponent,
        canActivate: [NonAuthGuard]
    },
    {
        path: 'recover-password',
        component: RecoverPasswordComponent,
        canActivate: [NonAuthGuard]
    },
    {path: '**', redirectTo: ''}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {relativeLinkResolution: 'legacy'})],
    exports: [RouterModule]
})
export class AppRoutingModule {}
