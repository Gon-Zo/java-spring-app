import React from "react";
import { ResponsiveBubble } from '@nivo/circle-packing'

export default () =>{
    return(
        <Test data={data}/>
    )
}

function Test(props) {
    let data = props.data
    return(
        <ResponsiveBubble
            root={data}
            margin={{ top: 20, right: 20, bottom: 20, left: 20 }}
            identity="name"
            value="loc"
            colors={{ scheme: 'nivo' }}
            padding={6}
            labelTextColor={{ from: 'color', modifiers: [ [ 'darker', 0.8 ] ] }}
            borderWidth={2}
            borderColor={{ from: 'color' }}
            defs={[
                {
                    id: 'lines',
                    type: 'patternLines',
                    background: 'none',
                    color: 'inherit',
                    rotation: -45,
                    lineWidth: 5,
                    spacing: 8
                }
            ]}
            fill={[ { match: { depth: 1 }, id: 'lines' } ]}
            animate={true}
            motionStiffness={90}
            motionDamping={12}
        />
    )
}

let data =
    {
        "name": "nivo",
        "color": "hsl(222, 70%, 50%)",
        "children": [
            {
                "name": "viz",
                "color": "hsl(270, 70%, 50%)",
                "children": [
                    {
                        "name": "stack",
                        "color": "hsl(232, 70%, 50%)",
                        "children": [
                            {
                                "name": "chart",
                                "color": "hsl(163, 70%, 50%)",
                                "loc": 72219
                            },
                            {
                                "name": "xAxis",
                                "color": "hsl(89, 70%, 50%)",
                                "loc": 31029
                            },
                            {
                                "name": "yAxis",
                                "color": "hsl(133, 70%, 50%)",
                                "loc": 55673
                            },
                            {
                                "name": "layers",
                                "color": "hsl(82, 70%, 50%)",
                                "loc": 64715
                            }
                        ]
                    },
                    {
                        "name": "pie",
                        "color": "hsl(58, 70%, 50%)",
                        "children": [
                            {
                                "name": "chart",
                                "color": "hsl(313, 70%, 50%)",
                                "children": [
                                    {
                                        "name": "pie",
                                        "color": "hsl(298, 70%, 50%)",
                                        "children": [
                                            {
                                                "name": "outline",
                                                "color": "hsl(241, 70%, 50%)",
                                                "loc": 180635
                                            },
                                            {
                                                "name": "slices",
                                                "color": "hsl(249, 70%, 50%)",
                                                "loc": 129882
                                            },
                                            {
                                                "name": "bbox",
                                                "color": "hsl(88, 70%, 50%)",
                                                "loc": 184069
                                            }
                                        ]
                                    },
                                    {
                                        "name": "donut",
                                        "color": "hsl(135, 70%, 50%)",
                                        "loc": 5091
                                    },
                                    {
                                        "name": "gauge",
                                        "color": "hsl(259, 70%, 50%)",
                                        "loc": 160404
                                    }
                                ]
                            },
                            {
                                "name": "legends",
                                "color": "hsl(152, 70%, 50%)",
                                "loc": 93420
                            }
                        ]
                    }
                ]
            },
            {
                "name": "colors",
                "color": "hsl(138, 70%, 50%)",
                "children": [
                    {
                        "name": "rgb",
                        "color": "hsl(329, 70%, 50%)",
                        "loc": 175114
                    },
                    {
                        "name": "hsl",
                        "color": "hsl(199, 70%, 50%)",
                        "loc": 151644
                    }
                ]
            },
            {
                "name": "utils",
                "color": "hsl(99, 70%, 50%)",
                "children": [
                    {
                        "name": "randomize",
                        "color": "hsl(66, 70%, 50%)",
                        "loc": 24041
                    },
                    {
                        "name": "resetClock",
                        "color": "hsl(282, 70%, 50%)",
                        "loc": 169398
                    },
                    {
                        "name": "noop",
                        "color": "hsl(332, 70%, 50%)",
                        "loc": 54580
                    },
                    {
                        "name": "tick",
                        "color": "hsl(92, 70%, 50%)",
                        "loc": 187006
                    },
                    {
                        "name": "forceGC",
                        "color": "hsl(251, 70%, 50%)",
                        "loc": 33129
                    },
                    {
                        "name": "stackTrace",
                        "color": "hsl(222, 70%, 50%)",
                        "loc": 55481
                    },
                    {
                        "name": "dbg",
                        "color": "hsl(8, 70%, 50%)",
                        "loc": 132339
                    }
                ]
            },
            {
                "name": "generators",
                "color": "hsl(150, 70%, 50%)",
                "children": [
                    {
                        "name": "address",
                        "color": "hsl(169, 70%, 50%)",
                        "loc": 181022
                    },
                    {
                        "name": "city",
                        "color": "hsl(248, 70%, 50%)",
                        "loc": 32537
                    },
                    {
                        "name": "animal",
                        "color": "hsl(320, 70%, 50%)",
                        "loc": 101477
                    },
                    {
                        "name": "movie",
                        "color": "hsl(354, 70%, 50%)",
                        "loc": 169810
                    },
                    {
                        "name": "user",
                        "color": "hsl(211, 70%, 50%)",
                        "loc": 113008
                    }
                ]
            },
            {
                "name": "set",
                "color": "hsl(279, 70%, 50%)",
                "children": [
                    {
                        "name": "clone",
                        "color": "hsl(321, 70%, 50%)",
                        "loc": 99466
                    },
                    {
                        "name": "intersect",
                        "color": "hsl(213, 70%, 50%)",
                        "loc": 145351
                    },
                    {
                        "name": "merge",
                        "color": "hsl(72, 70%, 50%)",
                        "loc": 123277
                    },
                    {
                        "name": "reverse",
                        "color": "hsl(337, 70%, 50%)",
                        "loc": 47198
                    },
                    {
                        "name": "toArray",
                        "color": "hsl(258, 70%, 50%)",
                        "loc": 107397
                    },
                    {
                        "name": "toObject",
                        "color": "hsl(167, 70%, 50%)",
                        "loc": 9630
                    },
                    {
                        "name": "fromCSV",
                        "color": "hsl(220, 70%, 50%)",
                        "loc": 147453
                    },
                    {
                        "name": "slice",
                        "color": "hsl(265, 70%, 50%)",
                        "loc": 165833
                    },
                    {
                        "name": "append",
                        "color": "hsl(336, 70%, 50%)",
                        "loc": 138135
                    },
                    {
                        "name": "prepend",
                        "color": "hsl(193, 70%, 50%)",
                        "loc": 139352
                    },
                    {
                        "name": "shuffle",
                        "color": "hsl(156, 70%, 50%)",
                        "loc": 156623
                    },
                    {
                        "name": "pick",
                        "color": "hsl(182, 70%, 50%)",
                        "loc": 172385
                    },
                    {
                        "name": "plouc",
                        "color": "hsl(27, 70%, 50%)",
                        "loc": 22860
                    }
                ]
            },
            {
                "name": "text",
                "color": "hsl(62, 70%, 50%)",
                "children": [
                    {
                        "name": "trim",
                        "color": "hsl(148, 70%, 50%)",
                        "loc": 16620
                    },
                    {
                        "name": "slugify",
                        "color": "hsl(125, 70%, 50%)",
                        "loc": 76033
                    },
                    {
                        "name": "snakeCase",
                        "color": "hsl(159, 70%, 50%)",
                        "loc": 192712
                    },
                    {
                        "name": "camelCase",
                        "color": "hsl(26, 70%, 50%)",
                        "loc": 95643
                    },
                    {
                        "name": "repeat",
                        "color": "hsl(133, 70%, 50%)",
                        "loc": 88247
                    },
                    {
                        "name": "padLeft",
                        "color": "hsl(308, 70%, 50%)",
                        "loc": 135363
                    },
                    {
                        "name": "padRight",
                        "color": "hsl(209, 70%, 50%)",
                        "loc": 15532
                    },
                    {
                        "name": "sanitize",
                        "color": "hsl(125, 70%, 50%)",
                        "loc": 174244
                    },
                    {
                        "name": "ploucify",
                        "color": "hsl(241, 70%, 50%)",
                        "loc": 159415
                    }
                ]
            },
            {
                "name": "misc",
                "color": "hsl(271, 70%, 50%)",
                "children": [
                    {
                        "name": "whatever",
                        "color": "hsl(102, 70%, 50%)",
                        "children": [
                            {
                                "name": "hey",
                                "color": "hsl(32, 70%, 50%)",
                                "loc": 135590
                            },
                            {
                                "name": "WTF",
                                "color": "hsl(230, 70%, 50%)",
                                "loc": 27376
                            },
                            {
                                "name": "lol",
                                "color": "hsl(30, 70%, 50%)",
                                "loc": 154872
                            },
                            {
                                "name": "IMHO",
                                "color": "hsl(292, 70%, 50%)",
                                "loc": 24524
                            }
                        ]
                    },
                    {
                        "name": "other",
                        "color": "hsl(217, 70%, 50%)",
                        "loc": 91953
                    },
                    {
                        "name": "crap",
                        "color": "hsl(96, 70%, 50%)",
                        "children": [
                            {
                                "name": "crapA",
                                "color": "hsl(243, 70%, 50%)",
                                "loc": 165659
                            },
                            {
                                "name": "crapB",
                                "color": "hsl(203, 70%, 50%)",
                                "children": [
                                    {
                                        "name": "crapB1",
                                        "color": "hsl(161, 70%, 50%)",
                                        "loc": 14878
                                    },
                                    {
                                        "name": "crapB2",
                                        "color": "hsl(98, 70%, 50%)",
                                        "loc": 43454
                                    },
                                    {
                                        "name": "crapB3",
                                        "color": "hsl(259, 70%, 50%)",
                                        "loc": 106293
                                    },
                                    {
                                        "name": "crapB4",
                                        "color": "hsl(160, 70%, 50%)",
                                        "loc": 81205
                                    }
                                ]
                            },
                            {
                                "name": "crapC",
                                "color": "hsl(248, 70%, 50%)",
                                "children": [
                                    {
                                        "name": "crapC1",
                                        "color": "hsl(134, 70%, 50%)",
                                        "loc": 140930
                                    },
                                    {
                                        "name": "crapC2",
                                        "color": "hsl(35, 70%, 50%)",
                                        "loc": 63196
                                    },
                                    {
                                        "name": "crapC3",
                                        "color": "hsl(347, 70%, 50%)",
                                        "loc": 156903
                                    },
                                    {
                                        "name": "crapC4",
                                        "color": "hsl(154, 70%, 50%)",
                                        "loc": 53386
                                    },
                                    {
                                        "name": "crapC5",
                                        "color": "hsl(106, 70%, 50%)",
                                        "loc": 128346
                                    },
                                    {
                                        "name": "crapC6",
                                        "color": "hsl(250, 70%, 50%)",
                                        "loc": 104909
                                    },
                                    {
                                        "name": "crapC7",
                                        "color": "hsl(107, 70%, 50%)",
                                        "loc": 178941
                                    },
                                    {
                                        "name": "crapC8",
                                        "color": "hsl(48, 70%, 50%)",
                                        "loc": 59269
                                    },
                                    {
                                        "name": "crapC9",
                                        "color": "hsl(266, 70%, 50%)",
                                        "loc": 107357
                                    }
                                ]
                            }
                        ]
                    }
                ]
            }
        ]
    }
