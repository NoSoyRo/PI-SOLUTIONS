from manim import *
import numpy as np

def f(c):
    c = c.get_value()
    x,y = [np.cos(c*i) for i in np.linspace(0,7*np.pi,1000)],[np.sin(c*i) for i in np.linspace(0,7*np.pi,1000)]
    return x,y



class AnimatedSquareToCircle(Scene):
    def construct(self):
        self.piCircle()
        self.createPiSolutions()
    def piCircle(self):
        ax = Axes(x_range=[-5, 5, 1], y_range=[-2, 2, 10]
                  , x_length=14         , y_length=7.5
                  , color=BLUE
                  , x_axis_config={"numbers_to_include": range(-3, 6 + 1, 1),
                                   "font_size": 24,}
                  , y_axis_config={"numbers_to_include": range(-20, 20 + 10, 10),
                                   "font_size": 24,}
                  , tips=False)

        p = ValueTracker(1)
        x,y = f(p)

        a = ax.plot_line_graph(x,y,add_vertex_dots = False).set_color(GRAY_B)

        a.add_updater(lambda m: m.become(ax.plot_line_graph([np.cos(p.get_value()*i) for i in np.linspace(0,7*np.pi,1000)],
                                                            [np.sin(i) for i in np.linspace(0,7*np.pi,1000)],
                                                            add_vertex_dots = False).set_color(GRAY_B)))

        self.play(Create(a))
        self.wait()
        self.play(ApplyMethod(p.increment_value,.5), run_time = 4  )
        self.play(ApplyMethod(p.increment_value,-.5), run_time = 4 )
        self.wait(1)
        self.circle = Circle(radius = 0.3, color = GRAY_B, fill_opacity = 1)
        self.play(ReplacementTransform(a,self.circle))
        self.graphPiSols = a

    def createPiSolutions(self):
        piSolutions = Text("Welcome to Pi-Solutions...", color = GRAY_BROWN)
        self.play(ReplacementTransform(self.circle, piSolutions), run_time = 2)
        self.wait(2)