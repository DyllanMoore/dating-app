import { Component } from '@angular/core';
import { loadFull } from 'tsparticles';
import { Container } from 'tsparticles-engine/types/Core/Container';
import { Engine } from 'tsparticles-engine/types/engine';
import { MoveDirection } from 'tsparticles-engine/types/Enums/Directions/MoveDirection';
import { ClickMode } from 'tsparticles-engine/types/Enums/Modes/ClickMode';
import { HoverMode } from 'tsparticles-engine/types/Enums/Modes/HoverMode';
import { OutMode } from 'tsparticles-engine/types/Enums/Modes/OutMode';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'FrontendV2';

  id = 'tsparticles';

  particlesOptions = {
    background: {
      color: {
        value: '#110000',
      },
    },
    fpsLimit: 120,
    interactivity: {
      events: {
        onClick: {
          enable: true,
          mode: ClickMode.push,
        },
        onHover: {
          enable: true,
          mode: HoverMode.repulse,
        },
        resize: true,
      },
      modes: {
        push: {
          quantity: 4,
        },
        repulse: {
          distance: 100,
          duration: 0.4,
        },
      },
    },
    particles: {
      color: {
        value: '#ffffff',
        opacity: 0.2,
      },
      links: {
        color: '#ffffff',
        distance: 150,
        enable: true,
        opacity: 0.5,
        width: 1,
      },
      collisions: {
        enable: true,
      },
      move: {
        direction: MoveDirection.none,
        enable: true,
        outModes: {
          default: OutMode.bounce,
        },
        random: true,
        speed: 6,
        straight: false,
      },
      number: {
        density: {
          enable: true,
          area: 800,
        },
        value: 80,
      },
      opacity: {
        value: 0.5,
      },
      shape: {
        options: {
          character: {
            value: ['\u2764', '\u2661', '\u2661'], // the text to use as particles, any string is valid, for escaping unicode char use the `\uXXXX` synta
          },
        },
        type: ['character'],
      },

      size: {
        value: { min: 10, max: 20 },
      },
    },
    detectRetina: true,
  };

  particlesLoaded(container: Container): void {
    console.log(container);
  }

  async particlesInit(engine: Engine): Promise<void> {
    console.log(engine);
    await loadFull(engine);
  }
}
